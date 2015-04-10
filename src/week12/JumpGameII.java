package week12;

//http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
	/*
	 * We use "last" to keep track of the maximum distance that has been reached
	 * by using the minimum steps "ret", whereas "curr" is the maximum distance
	 * that can be reached by using "ret+1" steps. Thus,
	 * curr = max(i+A[i]) where 0 <= i <= last.
	 */
    public int jump(int[] A) {
    	int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i+A[i]);
        }
        return ret;        
    }

}
