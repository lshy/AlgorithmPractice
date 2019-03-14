package backjoon.dp;

public class No4673 {

    final static int MAX_NUM = 10000;
    public static void main(String[] args) {

        boolean arr[] = new boolean[MAX_NUM+1];

        for(int i=1; i<=MAX_NUM; i++){
            int num = i;
            int sum = 0;
            while(num!=0){
                sum += num%10;
                num /= 10;
            }
            sum += i;

            if(sum > MAX_NUM)
                continue;

            arr[sum] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=MAX_NUM; i++){
            if(!arr[i])
                sb.append(i).append("\n");
        }

        System.out.print(sb.toString());
    }
}
