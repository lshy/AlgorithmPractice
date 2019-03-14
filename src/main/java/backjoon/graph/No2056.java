package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2056 {

    static int N;
    static int[] weight, topolArr;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        topolArr = new int[N + 1];
        weight = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            weight[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                topolArr[i]++;
                graph[num].add(i);
            }
        }


//        for(int i=0; i<=N; i++){
//            graph[i].sort(customComparator);
//        }

        topologicalSort();

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, weight[i]);
        }
        System.out.println(answer);
    }


    private static void topologicalSort() {

//        Queue<Integer> list = new LinkedList<>();
        CustomComparator customComparator = new CustomComparator();
        PriorityQueue<Integer> list = new PriorityQueue<>(customComparator);


        for (int i = 1; i <= N; i++) {
            if (topolArr[i] == 0)
                list.add(i);
        }

        while (!list.isEmpty()) {

            int num = list.remove();

            for (int next : graph[num]) {
                if (--topolArr[next] == 0) {
                    weight[next] += weight[num];
                    list.add(next);
                }

            }
        }
    }

    static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer p1, Integer p2) {
            return weight[p1] - weight[p2];
        }
    }
}
