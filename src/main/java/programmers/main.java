package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main {

    public static void main(String[] args) throws IOException {
        new main().run();
    }

    class Node {
        int to, cost;
        Node link;

        public Node(int to, int cost, Node link) {
            super();
            this.to = to;
            this.cost = cost;
            this.link = link;
        }
    }

    class Vertex implements Comparable<Vertex> {
        int no, distance;

        public Vertex(int no, int distance) {
            super();
            this.no = no;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance - o.distance;
        }
    }

    void run() throws IOException {
        // Input Data
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());

        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(in.readLine());

        Node[] adjList = new Node[V+1];
        for (int i=0,u,v,w; i<E; i++) {
            token = new StringTokenizer(in.readLine().trim());
            u = Integer.parseInt(token.nextToken());
            v = Integer.parseInt(token.nextToken());
            w = Integer.parseInt(token.nextToken());
            adjList[u] = new Node(v, w, adjList[u]);
        }

        // Solve - Dijkstra ALgorithm
        boolean[] checked = new boolean[V+1];
        int[] distance = new int[V+1];
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;
        queue.offer(new Vertex(K, 0));

        Vertex current;
        Node node;
        while (!queue.isEmpty()) {
            current = queue.poll();

            if (checked[current.no])  continue; // 방문한 곳은 패스
            checked[current.no] = true;

            node = adjList[current.no];
            while (node != null) {
                if (!checked[node.to] &&
                        distance[node.to] > current.distance + node.cost) {
                    distance[node.to] = current.distance + node.cost;
                    queue.offer(new Vertex(node.to, distance[node.to]));
                }
                node = node.link;
            }
        }

        // Output Data
        StringBuilder ans = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                ans.append("INF\n");
            } else {
                ans.append(distance[i]).append("\n");
            }
        }
        System.out.println(ans.toString());

    }


}
