package programmers.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1Test {
    @Test
    public void testArray(){
        Solution1 solution1 = new Solution1();
        assertSame(solution1.solution(new int[]{0, 0, 0, 0}), "0");
    }
}