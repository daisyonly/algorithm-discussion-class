package july_10;

public class HouseRobberII {

	  /** House Rubber Solution II */
	  public int rob(int[] num) {
	    if ((num==null) ||num.length==0) return 0; 
	    if (num.length==1) return num[0];

	    /** Maximun result of rubbing [first house..last hourse-1] and [second house .. last house] */
	    return Math.max(rob(num, 0, num.length-1), rob(num, 1, num.length));
	  }

	  private int rob(int[] nums,int left,int right) {
			int dp[] = new int[nums.length+2];
			dp[0]=0;dp[1]=0;
			for(int i=left;i<right;i++){			
				dp[i+2]=dp[i+1]>dp[i]+nums[i]? dp[i+1]:dp[i]+nums[i];
					
			}
					
			return dp[right+1];    
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberII a = new HouseRobberII();
		int nums[]={2,1};
		System.out.println(a.rob(nums));

	}

}
