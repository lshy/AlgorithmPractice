package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14499 {

    static int dx[] = {0, 1, -1, 0, 0};
    static int dy[] = {0, 0, 0, -1, 1};
    static int[] dice;
    static int[] raw;
    static int[] column;
    static int rawHead, columnHead;
    static int[][] map;
    static int N, M, x, y, K;

    public static void main(String[] args) throws IOException {
        dice = new int[7];
        raw = new int[]{1, 3, 6, 4};
        column = new int[]{1,5, 6, 2};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int d = Integer.parseInt(st.nextToken());
            int nextX = x + dx[d];
            int nextY = y + dy[d];
            if(checkBoundary(nextX, nextY)){
                continue;
            }
            x = nextX;
            y = nextY;
            move(nextX, nextY, d);

        }


    }

    private static void move(int x, int y, int number){
        if(number == 1){

            rawHead = checkLimit(rawHead -1);
            column[columnHead] = raw[rawHead];
            column[checkLimit(columnHead +2)] = raw[checkLimit(rawHead+2)];

        }else if(number == 2){

            rawHead = checkLimit(rawHead +1);
            column[columnHead] = raw[rawHead];
            column[checkLimit(columnHead +2)] = raw[checkLimit(rawHead+2)];

        }else if(number == 3){
            columnHead = checkLimit(columnHead +1);
            raw[rawHead] = column[columnHead];
            raw[checkLimit(rawHead +2)] = column[checkLimit(columnHead+2)];
        }else{
            columnHead = checkLimit(columnHead -1);
            raw[rawHead] = column[columnHead];
            raw[checkLimit(rawHead +2)] = column[checkLimit(columnHead+2)];

        }

        int badak = 7 - raw[rawHead];

        if(map[y][x] == 0){
            map[y][x] = dice[badak];
        }else{
            dice[badak] = map[y][x];
            map[y][x] = 0;
        }


        System.out.println(dice[raw[rawHead]]);

    }
    private static int checkLimit(int num){
        if(num > 3){
            return num - 4;
        }else if(num < 0){
            return num + 4;
        }else{
            return num;
        }
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= M || y <0 || y >= N){
            return true;
        }
        return false;
    }
}
