package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2610 {
    final static int MAX_LENGTH = 101;

    static int N, M;
    static int[][] map;
    static boolean[] isVisit;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        isVisit = new boolean[N+1];
        queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            Arrays.fill(map[i], MAX_LENGTH);
            map[i][i] = 0;
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = 1;
            map[B][A] = 1;
        }

        for(int k=1; k<=N; ++k){
            for(int i=1; i<=N; ++i){
                for(int j=1; j<=N; ++j){
                    map[i][j] = Math.min(map[i][k]+ map[k][j], map[i][j]);
                }
            }
        }

        PriorityQueue<Integer> answer = new PriorityQueue<>();

        int[] ansArr = new int[N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] == MAX_LENGTH)
                    continue;
                ansArr[i] = Math.max(map[i][j], ansArr[i]);
            }
        }

        for(int i=1; i<=N; ++i){

            int tmp = ansArr[i];
            int tmpAnswer = i;

            for(int j=1; j<=N; ++j){
                if(map[i][j] == MAX_LENGTH)
                    continue;

                isVisit[j] = true;
                if(tmp > ansArr[j]){
                    tmp = ansArr[j];
                    tmpAnswer = j;
                }

            }

            answer.add(tmpAnswer);
        }

        StringBuilder sb = new StringBuilder();
        int size = answer.size();
        sb.append(size).append("\n");

        for(int i =0; i<size; i++){
            sb.append(answer.remove()).append("\n");
        }

        System.out.print(sb.toString());

    }
}
