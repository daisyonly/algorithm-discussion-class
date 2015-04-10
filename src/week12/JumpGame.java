package week12;
//
//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] A) {
    	int max =A[0];
    	for(int i=1;i<A.length;i++){
    		if(max>=i)
    		 max = max > i+A[i] ? max : i+A[i];
    	}
    	if(max >= A.length-1) return true;
		return false;      
    }
    public static void main(String[] args) {
    	JumpGame aGame = new JumpGame();
    	int[] A = {0,1};
    	System.out.print(aGame.canJump(A));
	}
}
