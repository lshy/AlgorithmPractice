package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2252 {

    static int N, M;
    static int[] topolArr;
    static ArrayList<Integer>[] topolMap;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stack = new Stack<>();

        topolArr = new int[N+1];
        topolMap = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            topolMap[i] = new ArrayList<>();
        }

        for(int i= 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            topolMap[A].add(B);
            ++topolArr[B];
        }
        topologicalSort();

    }

    private static void topologicalSort(){

        Queue<Integer> list = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(topolArr[i] == 0)
                list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!list.isEmpty())  {

            int num = list.remove();
            sb.append(num).append(" ");

            for(int next : topolMap[num]){
                if(--topolArr[next] == 0)
                    list.add(next);
            }
        }
        System.out.println(sb.toString());
    }
}
