package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1051 {

    static int N, M, result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = 1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                checkMaxSquare(j, i);
            }
        }

        System.out.print(result);


    }

    private static void checkMaxSquare(int x, int y) {
        int num = map[y][x];
        for(int i= y +1; i<N; i++){
            if(map[i][x] == num){
                int length = i-y;
                if(x+length < M &&map[y][x+length] == num && map[i][x+length] == num){
                    result = Math.max(result, (length+1)*(length+1));
                }
            }
        }
    }


}

