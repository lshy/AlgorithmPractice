package backjoon;

import java.util.Scanner;

public class No2839 {
    static int arrTo3[] = {0, 3, 6, 9, 12};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = -1;

        for(int i=0; i< 5; i++){
            result = N -arrTo3[i];
            if(result% 5 == 0 && result >= 0){
                result /=5;
                result += (arrTo3[i]/3);
                break;
            }
        }

        result = result < 0 ? -1 : result;
        System.out.println(result);
    }
}
