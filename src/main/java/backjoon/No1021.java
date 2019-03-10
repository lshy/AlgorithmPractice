package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1021 {

    static boolean[] lotateQueue;
    static int N, M, head, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lotateQueue = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i= 0; i< M; i++){
            int num = Integer.parseInt(st.nextToken()) -1;

            if(num != head){
                search(num);
            }

            lotateQueue[num] = true;
            head = num;

            if(i == M-1)
                break;

            do{
                head = transeLocation(++head);
            }while(lotateQueue[head]);
        }

        System.out.println(answer);
    }

    private static void search(int num){

        int left = 0;
        int right = 0;
        int leftHead = head;
        int rightHead = head;

        while(true){

            while(true){
                leftHead = transeLocation(--leftHead);
                if(!lotateQueue[leftHead]){
                    left++;
                    break;
                }
            }


            if(num == leftHead){
                answer += left;
                break;
            }

            while(true){
                rightHead = transeLocation(++rightHead);
                if(!lotateQueue[rightHead]){
                    right++;
                    break;
                }
            }


            if(num == rightHead){
                answer += right;
                break;
            }
        }

    }

    private static int transeLocation(int num){
        if(num == N){
            return 0;
        }else if(num == -1){
            return N-1;
        }

        return num;
    }
}
