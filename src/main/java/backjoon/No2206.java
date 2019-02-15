package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No2206 {

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};

    static int N, M;
    static int[][] map;
    static Check[][] checkMap;

    static class Point{
        int x;
        int y;
        boolean crash;
        int length;
        Point(int x, int y, boolean crash, int length){
            this.x = x;
            this.y = y;
            this.crash =crash;
            this.length = length;
        }
    }

    static class Check{
        boolean remain;
        boolean notRemain;
        Check(){
            this.remain = false;
            this.notRemain = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        checkMap = new Check[N][M];

        for(int i=0; i< N; i++){
            String line = br.readLine();
            for(int j =0; j< M; j++){
                map[i][j] = line.charAt(j) - 48;
                checkMap[i][j] = new Check();
            }
        }

        checkMap[0][0].remain = true;

        LinkedList<Point> queue = new LinkedList<>();

        int answer = Integer.MAX_VALUE;

        queue.add(new Point(0, 0, true, 0));

        while(!queue.isEmpty()){

            Point p = queue.pop();

            p.length += 1;

            if(map[p.y][p.x] == 1)
                p.crash = false;



            if(p.y == N-1 && p.x == M-1){
                answer = Math.min(p.length, answer);
                break;
            }





            for(int i=0; i<4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];


                if(checkBoundary(nextX, nextY) || (map[nextY][nextX] == 1 && !p.crash ))
                    continue;


                Check check = checkMap[nextY][nextX];

                if( (p.crash && check.remain) || (!p.crash && check.notRemain) )
                    continue;

                if(p.crash){
                    checkMap[nextY][nextX].remain = true;
                }else{
                    checkMap[nextY][nextX].notRemain = true;
                }

                        queue.add(new Point(nextX, nextY, p.crash, p.length));
            }
        }

        if(!checkMap[N-1][M-1].remain && !checkMap[N-1][M-1].notRemain)
            answer = -1;


        System.out.print(answer);
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= M || y <0 || y >= N){
            return true;
        }
        return false;
    }
}
