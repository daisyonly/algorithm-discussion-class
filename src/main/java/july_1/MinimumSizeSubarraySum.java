package july_1;

public class MinimumSizeSubarraySum {
	
	public int minSubArrayLen(int s, int[] nums) {
        int end=0,start=0,ans=Integer.MAX_VALUE;
        int length=nums.length;
        int sum=0;
        while(end<length){
        	while(end<length && sum<s) {
        		sum += nums[end++];
        		//System.out.println(sum);
        	}
        	if(sum<s) break;
        	while(start<end && sum>=s)  {
        		sum-=nums[start++];
        		System.out.println(sum);
        	}
        	int tmp=end-start+1;
        	ans=tmp<ans? tmp:ans;
        	
        }	
		return ans==Integer.MAX_VALUE? 0:ans;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum a=new MinimumSizeSubarraySum();
		int nums[]={1,4,4};
		System.out.print(a.minSubArrayLen(4, nums));

	}

}
