package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7103 {
    static int N, T, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[182];

        for(int i=0; i<182; i++){
            arr[i] = i*i;
        }

        for(int t= 1; t<=T; t++){

            N = Integer.parseInt(br.readLine());
            answer = 0;

            answer = calculate(N, (int)Math.sqrt(N), 0);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());


    }

    private static int calculate(int num, int limit, int depth) {
        int answer = 0;
        int index = limit;
        if (depth == 4)
            return 0;

        for (int i = index; i > 0; i--) {
            int remain = num - arr[i];

            if(remain > arr[index])
                break;
            if (remain <5)
                if(depth + remain <4 )
                    answer += 1;
            else {
                answer += calculate(remain, i,depth + 1);
            }

        }

        return answer;
    }

    private static void algorithem(int now, int depth){

    }
}
