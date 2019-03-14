package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1389 {

    final static int MAX_LENGTH = 100;

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for(int i=1; i<= N; i++){
            Arrays.fill(map[i], MAX_LENGTH);
            map[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A][B] = 1;
            map[B][A] = 1;
        }

        for(int k=1; k<=N; ++k){
            for(int i=1; i<=N; ++i){
                for(int j=1; j<=N; ++j){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int save = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=N; i>=1; i--){
            int tmp = 0;
            for(int j=1; j<=N; j++){
                tmp += map[i][j];
            }

            if(save >= tmp){
                save = tmp;
                answer = i;
            }

        }



        System.out.println(answer);
    }

}
