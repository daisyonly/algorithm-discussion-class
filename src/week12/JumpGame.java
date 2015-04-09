package week12;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] A) {
    	int index =0;
    	while(index < A.length-1){
    		index=index+A[index];
    	}
    	if(index == A.length-1 ) return true;
		return false;      
    }
    public static void main(String[] args) {
    	JumpGame aGame = new JumpGame();
    	int[] A = {0,1};
    	System.out.print(aGame.canJump(A));
	}

}
