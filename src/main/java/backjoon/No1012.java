package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1012 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int T, M, N, K;
    static boolean[][] visitMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder =new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for(int t=1; t<=T; t++){
            int result = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            visitMap = new boolean[N][M];
            K = Integer.parseInt(st.nextToken());
            for(int i=0; i< K; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                visitMap[y][x] = true;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(visitMap[i][j]){
                        result++;
                        findWay(j, i);
                    }

                }
            }

            stringBuilder.append(result).append("\n");


        }

        System.out.print(stringBuilder.toString());
    }

    private static void findWay(int x, int y){
        visitMap[y][x] = false;
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(checkBoundary(nextX, nextY) || !visitMap[nextY][nextX])
                continue;

            findWay(nextX, nextY);
        }
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= M || y <0 || y >= N){
            return true;
        }
        return false;
    }
}
