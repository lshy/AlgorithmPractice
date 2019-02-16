package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1717 {
    static int[] root;
    static int[] rank;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        root = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++){
            root[i] = i;
            rank[i] = 0;
        }

        int c, a, b;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
                c = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if(c == 0){
                    union(a, b);
                }else{
                    if(find(a) == find(b)){
                        sb.append("YES\n");
                    }else{
                        sb.append("NO\n");
                    }
                }

        }
        System.out.println(sb.toString());
    }

    private static int find(int x){
        if(root[x] == x)
            return x;
        else
            return root[x] = find(root[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y)
            return;

        if(rank[x] < rank[y]){
            root[x] = y;
        }else{
            root[y] = x;
        }

        if(rank[x] == rank[y])
            rank[x]++;
    }
}
