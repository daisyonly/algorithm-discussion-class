package week12;

//http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
//https://leetcode.com/problems/jump-game-ii/
public class JumpGameIIOfMine {
	
    public int jump(int[] A) {
    	int ans =0;
    	int curMax =0;
    	int curMaxReach =0;
    	for(int i=0;i<A.length;i++){
    		if(i>curMaxReach){
    			curMaxReach =curMax;
    			ans++;
    		}
    		curMax = curMax>i+A[i] ? curMax:i+A[i];
    	}
		return ans;   	      
    }
    public static void main(String[] args) {
    	JumpGameIIOfMine aGameIIOfMine = new JumpGameIIOfMine();
    	int[] A = {2,3,1,1,4};
    	System.out.println(aGameIIOfMine.jump(A));
	}

}
