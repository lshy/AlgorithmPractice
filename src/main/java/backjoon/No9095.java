package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[12];
        num[1] = 1;
        num[2] = 2;
        num[3] = 4;

        for(int i= 4; i<11; i++){
            num[i] = num[i-3] + num[i-2] + num[i-1];
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(br.readLine());
            stringBuilder.append(num[now]).append("\n");
        }

        System.out.print(stringBuilder.toString());
    }
}
