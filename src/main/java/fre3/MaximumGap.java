package fre3;

import java.util.Arrays;

//https://leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space
public class MaximumGap {
	
	 public int maximumGap(int[] nums) {
		 if(nums==null||nums.length<2) return 0;
		 int maxNum = nums[0],minNum=nums[0];
		 for(int i=1;i<nums.length;i++){
			 maxNum = nums[i]>maxNum? nums[i]:maxNum;
			 minNum = nums[i]<minNum? nums[i]:minNum;
		 }
		 int gap = (maxNum-minNum)/nums.length+1;
		 int minBucket[] = new int[nums.length+1];
		 int maxBucket[] = new int[nums.length+1];
		 Arrays.fill(minBucket, Integer.MAX_VALUE);
		 Arrays.fill(maxBucket, Integer.MIN_VALUE);
		 for(int i=0;i<nums.length;i++){
			 int index = (nums[i]-minNum)/gap;
			 minBucket[index] = nums[i]<minBucket[index]? nums[i]:minBucket[index];
			 maxBucket[index] = nums[i]>maxBucket[index]? nums[i]:maxBucket[index];
		 }
		 int maxGap=gap;
		 int preMax = minNum;
		 for(int i=0;i<nums.length+1;i++){
			if(minBucket[i]==Integer.MAX_VALUE && maxBucket[i]==Integer.MIN_VALUE) continue;
			int tmp = minBucket[i]-preMax;
			maxGap = tmp>maxGap? tmp:maxGap;
			preMax = maxBucket[i];
		 }
		 return maxGap;
	        
	 }
	 
	 public int maximumGap2(int[] num) {
		    if (num == null || num.length < 2)
		        return 0;
		    // get the max and min value of the array
		    int min = num[0];
		    int max = num[0];
		    for (int i:num) {
		        min = Math.min(min, i);
		        max = Math.max(max, i);
		    }
		    // the minimum possibale gap, ceiling of the integer division
		    int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
		    int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
		    int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
		    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		    // put numbers into buckets
		    for (int i:num) {
		        if (i == min || i == max)
		            continue;
		        int idx = (i - min) / gap; // index of the right position in the buckets
		        bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
		        bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		    }
		    // scan the buckets for the max gap
		    int maxGap = Integer.MIN_VALUE;
		    int previous = min;
		    for (int i = 0; i < num.length - 1; i++) {
		        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
		            // empty bucket
		            continue;
		        // min value minus the previous value is the current gap
		        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
		        // update previous bucket value
		        previous = bucketsMAX[i];
		    }
		    maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
		    return maxGap;
	}
	 public static void main(String[] args) {
		 MaximumGap aGap= new MaximumGap();
		 int[] nums = {1,2,3,4,10};
		 System.out.println(aGap.maximumGap(nums));
		 
	}

}
