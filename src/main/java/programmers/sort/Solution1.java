package programmers.sort;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
//    class StringInt implements Comparable<StringInt>{
//
//        public String stringNumber;
//
//        @Override
//        public int compareTo(StringInt o) {
//            return stringNumber.compareTo(o.stringNumber);
//        }
//
//
//    }
    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];
        for(int i=0; i< numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return a.compareTo(b);
        });

        if(arr[arr.length-1].equals("0")){
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i= arr.length -1; i>=0; i--){
            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }
}
