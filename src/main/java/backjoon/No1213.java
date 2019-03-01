package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int length = line.length();


            char[] arr = line.toCharArray();
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();

            boolean flag = false;
            char tmp = ' ';
            String answer = null;

        for(int i=0; i< length; ){
            if(i == length -1){
                if(flag)
                    answer = "I'm Sorry Hansoo";

                tmp = arr[i];
                break;
            }
                if(arr[i] == arr[i+1]){
                    sb.append(arr[i]);
                    i += 2;
                }else{
                    if(flag){
                        answer = "I'm Sorry Hansoo";
                        break;
                    }else{
                        flag = true;
                        tmp = arr[i];
                        i++;
                    }
                }
            }

            if(answer == null){
                if(tmp == ' '){
                    answer = sb.toString() + sb.reverse().toString();
                }else{
                    answer = sb.toString() + tmp + sb.reverse().toString();
                }
            }

            System.out.println(answer);

    }
}
