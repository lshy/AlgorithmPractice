package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6603 {
    static final int LOTTO_LIMIT = 6;
    static int k;
    static int[] arr, origin;
    static StringBuilder stringBuilder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0)
                break;

            arr = new int[k];
            origin = new int[k];


            for(int i=0; i<k; i++){
                origin[i] = Integer.parseInt(st.nextToken());
            }

            recursice(0, 0);
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder.toString());



    }

    private static void recursice(int start, int depth){
        if(depth == LOTTO_LIMIT){
            for(int i=0; i<LOTTO_LIMIT; i++){
                stringBuilder.append(arr[i]).append(" ");
            }
            stringBuilder.append("\n");
        }else{
            for(int i= start; i<k; i++){
                arr[depth] = origin[i];
                recursice(i+1, depth+1);
            }
        }
    }
}
