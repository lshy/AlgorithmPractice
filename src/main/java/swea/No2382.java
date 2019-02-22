package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2382 {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static class Cells implements Comparable<Cells>{

        int x;
        int y;
        int amount;
        int direction;

        Cells(int y, int x, int amount, int direction){
            this.x = x;
            this.y = y;
            this.amount = amount;
            this.direction = direction;
        }

        public int compareTo(Cells p) {
            if (this.amount > p.amount) {
                return -1;
            } else if (this.amount < p.amount) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static class Room{

        PriorityQueue<Cells> list;

        Room(){
            list = new PriorityQueue<>();
        }

    }

    static int T, N, M, K;
    static Room[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        LinkedList<Cells> queue;
        for(int t = 1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            map = new Room[N][N];

            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                Cells cells = new Cells(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
                queue.add(cells);
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = new Room();
                }
            }

            for(int k=0; k<M; k++){
                //move
                while(!queue.isEmpty()){
                    Cells cells = queue.poll();
                    cells.x += dx[cells.direction];
                    cells.y += dy[cells.direction];

                    if(cells.x == 0 || cells.y == 0 || cells.x == N-1 || cells.y == N-1){
                        cells.amount /= 2;
                        cells.direction = reverseDirection(cells.direction);
                    }

                    map[cells.y][cells.x].list.add(cells);
                }


                //union

                for(int i =0; i<N; i++){
                    for(int j=0; j<N; j++){

                        if(map[i][j].list.isEmpty())
                            continue;

                        Cells cells = map[i][j].list.poll();

                        while(!map[i][j].list.isEmpty()){
                            cells.amount += map[i][j].list.poll().amount;
                        }

                        queue.add(cells);


                    }
                }
            }

            int result = 0;
            for(Cells cells : queue){
                result += cells.amount;
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");

        }

        System.out.print(sb.toString());

    }

    private static int reverseDirection(int d){
        switch (d){
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;

        }
        return 0;
    }


    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= N || y <0 || y >= N){
            return true;
        }
        return false;
    }
}
