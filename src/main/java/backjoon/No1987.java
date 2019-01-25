package backjoon;

import java.util.*;

public class No1987 {

    static char[][] map;

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int R;
    static int C;
    static int answer = 0;
    static int tmp = 0;
    static boolean alphbet[];

    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        alphbet = new boolean[130];

        sc.nextLine();


        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    private static void dfs(int x, int y) {
        tmp++;
        answer = Math.max(answer, tmp);

        alphbet[map[y][x]] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < C && nextY >= 0 && nextY < R && !alphbet[map[nextY][nextX]]) {
                dfs(nextX, nextY);
            }
        }

        tmp--;
        alphbet[map[y][x]] = false;
    }
}
