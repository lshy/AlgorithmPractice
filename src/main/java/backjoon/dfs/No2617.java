package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2617 {

    static int N, M, maximum, answer;
    static ArrayList<Integer>[] left, right;
    static boolean[] isVisit;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        left = new ArrayList[N + 1];
        right = new ArrayList[N + 1];
        weight = new int[N + 1];
        maximum = (N + 1) / 2;
        isVisit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            left[small].add(big);
            right[big].add(small);
        }

        for(int i=1; i<=N; i++){
            if(dfsL(i) > maximum || resetMap()|| dfsR(i) > maximum)
                answer++;

            resetMap();
        }

        System.out.println(answer);

    }

    private static boolean resetMap(){

        for(int i=1; i<=N; i++){
            isVisit[i] = false;
        }

        return false;
    }

    private static int dfsL(int num) {

        int count = 1;

        isVisit[num] = true;
        for (int next : left[num]) {

            if (isVisit[next])
                continue;

            count += dfsL(next);
        }


        return count;
    }

    private static int dfsR(int num) {

        int count = 1;

        isVisit[num] = true;
        for (int next : right[num]) {

            if (isVisit[next])
                continue;

            count += dfsR(next);
        }

        return count;
    }
}
