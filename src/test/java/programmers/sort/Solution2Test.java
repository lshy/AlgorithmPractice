package programmers.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void solution() {
        Solution2 solution2 = new Solution2();
        assertEquals(solution2.solution(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8, 8, 9, 9, 10, 10, 10}), 7);
    }
}