package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No16236 {

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N;
    static int[][] space;
    static int[][] visitDistance;
    static int startX, startY;
    static int sharkSize;
    static int sharkRemain;
    static boolean flag;
    static class Point{
        int x;
        int y;
        int distance;
        Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        visitDistance = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                visitDistance[i][j] = -1;
                if(space[i][j] == 9){
                    startX = j;
                    startY = i;
                }
            }
        }

        sharkSize = 2;
        sharkRemain = 2;
        flag = true;

        LinkedList<Point> points = new LinkedList<>();

        Point start = new Point(startX, startY, 0);
        int reult = 0;

        while(flag){

            if(sharkRemain == 0){
                sharkSize++;
                sharkRemain = sharkSize;
            }

            reult += start.distance;
            System.out.println(start.x + " " + start.y+ " " + start.distance);

            points.push(new Point(start.x, start.y, 0));
            space[start.y][start.x] = 0;
            start.distance = 500;
            flag = false;

            while(!points.isEmpty()){

                Point p = points.pop();

                if(visitDistance[p.y][p.x] != -1 && visitDistance[p.y][p.x] <= p.distance){
                    continue;
                }

                if(space[p.y][p.x] != 0 && space[p.y][p.x] < sharkSize){
                    flag = true;
                    start = compareBetter(start, p);
                    continue;
                }

                visitDistance[p.y][p.x] = p.distance;

                for(int i=0; i<4; i++){
                    int nextX = p.x + dx[i];
                    int nextY = p.y + dy[i];
                    if(checkBoundary(nextX, nextY) || space[nextY][nextX] > sharkSize){
                        continue;
                    }

                    if(space[nextY][nextX] <= sharkSize && start.distance > visitDistance[nextY][nextX]){
                        points.add(new Point(nextX, nextY, p.distance +1 ));
                    }
                }
            }

            sharkRemain--;
            resetMap();
        }

        System.out.println(reult);



    }

    private static Point compareBetter(Point a, Point b){
        if(a.distance == b.distance){
            if(a.y == b.y){
                return a.x < b.x ? a : b ;
            }else{
                return a.y < b.y? a: b;
            }
        }else{
            return a.distance < b.distance ? a : b;
        }
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= N || y <0 || y >= N){
            return true;
        }
        return false;
    }

    private static void resetMap(){
        for(int i=0; i<N; i++){
            for ( int j=0; j<N; j++){
                visitDistance[i][j] = -1;
            }
        }
    }
}
