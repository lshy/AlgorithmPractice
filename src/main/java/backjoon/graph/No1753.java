package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1753 {

    static final int MAX_WEIGHT = Integer.MAX_VALUE;
    static final String text = "INF";

    static int V, E, K;
    static int[] dist;
    static ArrayList<FromTo>[] list;

    static class FromTo implements Comparable<FromTo> {
        int i;
        int d;

        FromTo(int i, int d) {
            this.i = i;
            this.d = d;
        }

        @Override
        public int compareTo(FromTo o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        list = new ArrayList[V + 1];

        boolean[] isVisit = new boolean[V + 1];


        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            dist[i] = MAX_WEIGHT;
        }

        dist[K] = 0;

        PriorityQueue<FromTo> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new FromTo(K, 0));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new FromTo(v, w));

        }
        while (!priorityQueue.isEmpty()) {
            FromTo fromTo = priorityQueue.remove();
            if (dist[fromTo.i] < fromTo.d)
                continue;

            if(isVisit[fromTo.i])
                continue;

            isVisit[fromTo.i] = true;

            for (FromTo next : list[fromTo.i]) {
                int compare = dist[fromTo.i] + next.d;

                if (dist[next.i] > compare) {
                    dist[next.i] = compare;
                    priorityQueue.add(new FromTo(next.i, compare));
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            int num = dist[i];
            if (num != MAX_WEIGHT) {
                sb.append(num).append("\n");
            } else {
                sb.append(text).append("\n");
            }

        }

        System.out.print(sb.toString());

    }
}