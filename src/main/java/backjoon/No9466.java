package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class No9466 {
    static int T, n;
    static int answer;
    static int[] map;
    static boolean[] isVisit;
    static List<Integer> saveQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int k=0; k< T; k++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n+1];
            isVisit = new boolean[n+1];
            st = new StringTokenizer(br.readLine());

            answer = 0;

            for(int j=1; j<= n; j++){
                map[j] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                if(isVisit[i])
                    continue;

                saveQueue = new LinkedList<>();
                algorithm(i);
            }

            System.out.println(answer);
        }
    }

    private static void algorithm(int location){
        isVisit[location] = true;
        saveQueue.add(location);

        int myPair = map[location];

        if(isVisit[myPair]){
            if(myPair == location){
                answer += (saveQueue.size()-1);
            }else{
                int tmp = saveQueue.indexOf(myPair);
                if(tmp != -1){
                    answer += tmp;
                }else{
                    answer += saveQueue.size();
                }
            }
        }else{
            algorithm(myPair);
        }
    }
}
