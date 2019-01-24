package programmers.stackqueue;

import java.util.Stack;

public class Solution0 {
        public int solution(String arrangement) {

            int answer = 0;
            int size = 0;
            int lenght = arrangement.length();
            for(int i=0; i<lenght; i++){
                if(arrangement.charAt(i) == '('){
                    size += 1;
                }else{
                    size -= 1;
                    if(arrangement.charAt(i-1) == '('){
                        answer += size;
                    }else{
                        answer += 1;
                    }
                }
            }

            return answer;
        }
}
