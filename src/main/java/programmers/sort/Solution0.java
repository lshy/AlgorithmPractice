package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0 {
    public int[] solution(int[] array, int[][] commands) {

        List<Integer> result =new ArrayList<>();
        for(int[] command : commands){
            int size = command[1] - command[0] + 1;
            int[] tmp = new int[size];
            System.arraycopy(array, command[0]-1, tmp, 0, size);
            Arrays.sort(tmp);
            result.add(tmp[command[2]-1]);
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
