package backjoon;

import java.util.Scanner;

public class No1009 {
    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){

            int a = sc.nextInt();
            int b = sc.nextInt();

            a %= 10;
            int answer = a;
            if(a == 0){
                answer = 10;
            }else{
                for(int j =1; j< b; j++){
                    answer = (answer*a) % 10;
                }
            }

            System.out.println(answer);

        }
    }
}
