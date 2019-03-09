package programmers.sort;

import java.util.Arrays;

public class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int lenght = citations.length;
        for(int i= lenght-1; i>= 0; i--){
            answer++;
            if(citations[i] <= answer)
                return answer-1;
        }
        return 0;
    }
}
