package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16234 {

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N, L, R;
    static int[][] map;
    static int[][] visitMap;
    static int[] unionLand;
    static int count;
    static int union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visitMap = new int[N][N];
        unionLand = new int[N*N];
        count =0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                visitMap[i][j] = -1;
            }
        }


        int answer = 0;
        boolean flag = true;


        while(true){
            union = 0;
            flag = false;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visitMap[i][j] == -1){
                        unionLand[union] = 0;
                        searchUniion(j, i);
                        if(count >1){
                            flag = true;
                        }
                        unionLand[union] /= count;
                        union++;
                        count = 0;
                    }

                }
            }

            if(flag){
                answer++;
            }else{
                break;
            }
            resetMap();
            printMap();



        }

        System.out.println(answer);

    }

    private static void searchUniion(int x, int y){

        count++;
        visitMap[y][x] = union;
        unionLand[union] += map[y][x];

        for(int i=0; i<4; i++){
            int nextX = x +dx[i];
            int nextY = y + dy[i];
            if(checkBoundary(nextX, nextY) || visitMap[nextY][nextX] != -1){
                continue;
            }

            int depth = Math.abs(map[y][x] - map[nextY][nextX]);

            if(depth >= L && depth <= R ){
                searchUniion(nextX, nextY);
            }
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
                map[i][j] = unionLand[visitMap[i][j]];
                visitMap[i][j] = -1;
            }
        }
    }

    private static void printMap(){
        for(int i=0; i<N; i++){
            for ( int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
