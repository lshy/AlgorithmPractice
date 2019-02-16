package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1261 {

    static int N, M;
    static int[][] map, visitMap;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static Queue<Point> queue;

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int crash;
        Point(int x, int y, int crash){
            this.x = x;
            this.y = y;
            this.crash = crash;
        }
        public int compareTo(Point p) {
            if (this.crash > p.crash) {
                return 1;
            } else if (this.crash < p.crash) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<>();

        map = new int[N][M];
        visitMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - 48;
                visitMap[i][j] = Integer.MAX_VALUE;
            }
        }

        visitMap[N-1][M-1] = Integer.MAX_VALUE;
        queue.offer(new Point(0, 0, 0));
        visitMap[0][0] = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x == N-1 && p.y == M-1)
                break;

            for(int i=0; i<4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (checkBoundary(nextX, nextY))
                    continue;

                    if(map[nextY][nextX] ==1){
                        if(visitMap[nextY][nextX] > p.crash +1){
                            visitMap[nextY][nextX] = p.crash +1;
                            queue.offer(new Point(nextX, nextY, p.crash +1));
                        }
                    }else{
                        if(visitMap[nextY][nextX] > p.crash){
                            visitMap[nextY][nextX] = p.crash;
                            queue.offer(new Point(nextX, nextY, p.crash));

                        }
                    }

            }
        }


        System.out.println(visitMap[N-1][M-1]);
    }


        private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= M || y <0 || y >= N){
            return true;
        }
        return false;
    }
}
