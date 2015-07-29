package july_10;

import sun.misc.FpUtils;

public class HouseRobber {
	
	public int rob(int[] nums) {
		int dp[] = new int[nums.length+2];
		dp[0]=0;dp[1]=0;
		for(int i=0;i<nums.length;i++){
			for(int j=0;j<i+1;j++){
				int tmp=dp[j]+nums[i];
				if(tmp>dp[i+2]) dp[i+2]=tmp;
			}
		}
		int ans=0;
		for(int i=0;i<dp.length;i++){
			ans = dp[i]>ans? dp[i]:ans;
		}
		
		return ans;    
    }
	public static void main(String[] args) {
		HouseRobber a = new HouseRobber();
		int nums[]={2,1};
		System.out.println(a.rob(nums));
	}

}
