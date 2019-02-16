package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No3197 {

    static class Point{
        int x;
        int y;
        int time;
        int sex;
        Point(int x, int y, int time, int sex){
            this.x = x;
            this.y = y;
            this.time = time;
            this.sex = sex;
        }
    }

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};

    static int R, C;
    static char[][] map;
    static int[][] checkMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        checkMap = new int[R][C];
        LinkedList<Point> queue = new LinkedList<>();
        LinkedList<Point> tmpQueue = new LinkedList<>();

        int first = 1;
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                char input = line.charAt(j);
                checkMap[i][j] = 0;
                map[i][j] = input;
                if(input == 'L'){
                    queue.add(new Point(j, i, 0, first));
                    checkMap[i][j] = first;
                    first = 2;
                }else if(input == '.'){
                    queue.add(new Point(j, i, 0, 0));
                }


            }
        }

        boolean flag = true;
        int answer =0;
        while(flag){
            Point p = queue.pop();

            for(int i=0; i<4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if(checkBoundary(nextX, nextY))
                    continue;

                if(checkMap[nextY][nextX] == p.sex)
                    continue;

                if(checkMap[nextY][nextX] != 0){
                    if(p.sex == 2){
                        answer += 1;
                    }

                    flag = false;
                    answer += p.time;
                    break;
                }

                checkMap[nextY][nextX] = p.sex;

                if(map[nextY][nextX] == 'X'){
                    queue.add(new Point(nextX, nextY, p.time +1, p.sex));
                }else{
                    queue.push(new Point(nextX, nextY, p.time, p.sex));
                }

            }

        }
        System.out.println(answer);




    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= C || y <0 || y >= R){
            return true;
        }
        return false;
    }

    private static void printMap(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(checkMap[i][j]);
            }
            System.out.println();
        }

    }
}
