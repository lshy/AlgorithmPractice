package programmers.stackqueue;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Solution0Test {
    @Test
    public void testSolution0(){
        Solution0 solution1 = new Solution0();

        assertThat(solution1.solution("()(((()())(())()))(())")).isEqualTo(17);
    }

}