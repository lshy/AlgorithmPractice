package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No4195 {
    static int[] root, rank, nodeCount;
    static Map<String, Integer> map;
    static int T, F, index;
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();
        root = new int[MAX];
        rank = new int[MAX];
        nodeCount = new int[MAX];

        T = Integer.parseInt(st.nextToken());

        int a, b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            F = Integer.parseInt(st.nextToken());
            map.clear();
            index = 0;
            for (int j = 0; j < F; j++) {

                st = new StringTokenizer(br.readLine());
                a = findInMap(st.nextToken());
                b = findInMap(st.nextToken());

                union(a, b);

                int sum = getNodeCount(find(a));
                sb.append(sum);
                sb.append("\n");

            }
        }
        System.out.println(sb.toString());
    }

    private static int findInMap(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            map.put(key, index);
            root[index] = index;
            rank[index] = 0;
            nodeCount[index] = 1;
            return index++;
        }
    }

    private static int find(int x) {
        if (root[x] == x)
            return x;
        else {
            return root[x] = find(root[x]);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;

        if (rank[x] > rank[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        nodeCount[y] = nodeCount[x] + nodeCount[y];
        nodeCount[x] = 1;

        root[x] = y;

        if (rank[x] == rank[y])
            rank[x] += 1;
    }

    private static int getNodeCount(int x) {
        return nodeCount[x];
    }
}
