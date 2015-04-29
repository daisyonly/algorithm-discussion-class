package fre3;

//https://leetcode.com/problems/maximum-subarray/
//https://leetcode.com/discuss/694/how-solve-maximum-subarray-using-divide-and-conquer-approach
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int max = nums[0];
		int sum = nums[0];
		for(int i=1;i<nums.length;i++){
			if(sum<0) sum=0;
			sum = sum+nums[i];
			max = max>sum ? max:sum;
		}
		return max;      
    }
	public static void main(String[] args) {
		int A[]={-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray a =new MaximumSubarray();
		System.out.println(a.maxSubArray(A));
	}

}
