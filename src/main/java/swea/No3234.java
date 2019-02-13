package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3234 {
    static int T, N;
    static int[] numbers;
    static boolean[] isVisit;
    static int answer, leftSum, rightSum, weightSum;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i=1; i<= T; i++){

            N = Integer.parseInt(br.readLine());

            numbers = new int[N];
            isVisit = new boolean[N];
            answer = 0;
            weightSum = 0;

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
                weightSum += numbers[j];
            }

            weightSum /= 2;
            weightSum += 1;

            for(int k = 0; k<N; k++){
                flag = false;
                leftSum = 0;
                rightSum = 0;

                dfs(1, k,true);
            }
            System.out.println("#"+i+" " + answer);
        }
    }

    private static void dfs(int depth, int turn, boolean isLeft){

        isVisit[turn] = true;


        if(isLeft){
            leftSum += numbers[turn];
        }else{
            rightSum += numbers[turn];
        }

        if(weightSum <= leftSum){
            int a = 0;
            for(int i=0; i<N; i++){
                if(isVisit[i])
                    continue;

                a++;
            }

            int asd = 1;
            for(int i=1; i<= a; i++){
                asd *= i;
            }
            for(int i=0; i<a; i++){
                asd *= 2;
            }
            answer += asd;
        }else{

            if(depth == N){
                answer++;
            }else{

                for(int i=0; i< N; i++){

                    if(isVisit[i])
                        continue;

                    if(rightSum + numbers[i] <= leftSum){
                        dfs(depth+1, i, false);
                    }

                    dfs(depth+1, i, true);

                }

            }
        }


        isVisit[turn] = false;

        if(isLeft){
            leftSum -= numbers[turn];
        }else{
            rightSum -= numbers[turn];
        }


    }
}
