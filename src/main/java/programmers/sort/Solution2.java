package programmers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = Arrays.stream(citations).mapToObj(Integer::new).collect(Collectors.toList());
        list.sort(Collections.reverseOrder());
        for(int i=0; i< list.size(); i++){
            if(i+1 >= list.get(i)){
                return i+1;
            }
        }
        return 0;
    }
}
