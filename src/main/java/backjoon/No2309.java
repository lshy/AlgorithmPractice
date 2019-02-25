package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2309 {

    static final int DEPTH = 2;
    static int[] arr;
    static boolean[] visitCheck;
    static boolean flag = false;
    static int result;
    static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stringBuilder = new StringBuilder();
        arr = new int[9];
        visitCheck = new boolean[9];

        result = 0;

        for(int i=0; i< 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            result += arr[i];
        }

        result -= 100;
        Arrays.sort(arr);
        recursive(8, 0,0);

        System.out.print(stringBuilder.toString());


    }

    static void recursive(int start, int sum, int depth){
        if(depth == DEPTH){
            if(sum == result){
                flag =true;
                for(int i=0; i<9; i++){
                    if(visitCheck[i])
                        continue;
                    stringBuilder.append(arr[i]).append("\n");

                }
            }

        }else{
            for(int i= start; i>-1; i--){
                visitCheck[i] = true;
                recursive(i-1, sum+arr[i], depth+1);
                if(flag)
                    break;

                visitCheck[i] = false;
            }
        }
    }
}
