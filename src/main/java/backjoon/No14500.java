package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14500 {

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int result = 0;
    static int[][] maps;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bfs(j, i, j, i, 0, 0);
                checkPlus(j, i);
            }
        }

        System.out.print(result);


    }

    private static void bfs(int x, int y, int bx, int by, int depth, int dump){
        depth++;
        dump += maps[y][x];

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(checkBoundary(nextX, nextY) || (nextX == bx && nextY == by)){
                continue;
            }
            if(depth == 4){
                result = Math.max(result, dump);
            }else{
                bfs(nextX, nextY, x, y, depth, dump);
            }

        }
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= M || y <0 || y >= N){
            return true;
        }
        return false;
    }

    private static void checkPlus(int x, int y){
        int sum = maps[y][x];
        int minScore = Integer.MAX_VALUE;
        int depth = 0;
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(checkBoundary(nextX, nextY)){
                continue;
            }else{
                depth++;
                minScore = Math.min(minScore, maps[nextY][nextX]);
                sum += maps[nextY][nextX];
            }
        }

        if(depth == 4){
            result = Math.max(result, sum - minScore);
        }else if(depth == 3){
            result = Math.max(result, sum);
        }

    }
}
