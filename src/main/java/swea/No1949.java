package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1949 {

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static int T, N, K, answer;
    static int map[][];
    static boolean visitMap[][];
    static Queue<Point> list;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        list = new LinkedList<>();

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visitMap = new boolean[N][N];


            int maxHeight = 0;
            answer = 0;

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {

                    int num = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, num);
                    map[i][j] = num;
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == maxHeight)
                        list.add(new Point(j, i));
                }
            }
            while(!list.isEmpty()){
                Point p = list.remove();
                algorithm(p.x, p.y, 0, map[p.y][p.x], true);
            }



            sb.append("#")
                    .append(t)
                    .append(" ")
                    .append(answer)
                    .append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void algorithm(int x, int y, int depth, int height, boolean remain){

        visitMap[y][x] = true;
        depth += 1;

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(checkBoundary(nextX, nextY) || visitMap[nextY][nextX])
                continue;

            if(height > map[nextY][nextX]){
                algorithm(nextX, nextY, depth, map[nextY][nextX], remain);
            }else{
                if(remain && map[nextY][nextX] - height < K){
                    algorithm(nextX, nextY, depth, height-1, false);
                }
            }
        }

        answer = Math.max(answer, depth);
        visitMap[y][x] = false;
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= N || y <0 || y>= N)
            return true;

        return false;
    }
}
