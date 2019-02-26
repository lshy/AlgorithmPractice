package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1065 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int result =99;
        if(N < 100){
            System.out.println(N);
        }else{
            for(int i= 100; i<=N; i++){
                int num = i;
//                String num = String.valueOf(i);
                int first = num / 100;
                int second = (num - first*100)/10;
                int third = num % 10;
                if(first-second == second - third){
                    result++;
                }
            }
            System.out.println(result);
        }

    }
}
