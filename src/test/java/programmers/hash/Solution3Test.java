package programmers.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution3Test {

    @Test
    public void testArray(){
        Solution3_1 solution3 = new Solution3_1();
        solution3.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 500, 500, 500, 500});


        assertArrayEquals(new int[]{3, 1, 4, 5}, solution3.solution(new String[]{"classic", "pop", "classic", "pop", "classic", "classic"}, new int[]{400,600,150,2500,500,500}));

    }

}