package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10026 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, answer;
    static int map[][];
    static boolean visitMap[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visitMap = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();

        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visitMap[i][j])
                    continue;

                answer++;
                dfs(j, i);
            }
        }

        sb.append(answer).append(" ");

        answer = 0;
        resetMap();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visitMap[i][j])
                    continue;

                answer++;

                if(map[i][j] == 'B'){
                    dfs(j, i);
                }else{
                    dfsB(j, i);
                }

            }
        }

        sb.append(answer).append("\n");

        System.out.print(sb.toString());

    }

    private static void dfs(int x, int y) {

        visitMap[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nexyY = y + dy[i];

            if (checkBoundary(nextX, nexyY) || visitMap[nexyY][nextX])
                continue;

            if(map[nexyY][nextX] != map[y][x])
                continue;

            dfs(nextX, nexyY);
        }
    }

    private static void dfsB(int x, int y) {

        visitMap[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x +dx[i];
            int nexyY = y + dy[i];


            if (checkBoundary(nextX, nexyY) || visitMap[nexyY][nextX])
                continue;

            if(map[nexyY][nextX] == 'B'){
                continue;
            }
            dfsB(nextX, nexyY);
        }
    }

    private static void resetMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visitMap[i][j] = false;
            }
        }
    }

    private static boolean checkBoundary(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;

    }
}
