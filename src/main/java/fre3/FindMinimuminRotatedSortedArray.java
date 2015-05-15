package fre3;

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int min = nums[0];
		int left =0,right=nums.length-1;
		while(left<=right){
			int mid = (left+right)>>1;
		    min=nums[mid]<min? nums[mid]:min;
		    if(nums[mid]<nums[left]){
		    	right=mid-1;
		    }else{
		    	if(nums[right]>nums[mid]) right=mid-1;
		    	else left= mid+1;
		    }
		}
		return min;      
    }
	public static void main(String[] args) {
		int nums[]={4,5,6,7,0,1,2};
		FindMinimuminRotatedSortedArray array= new FindMinimuminRotatedSortedArray();
		System.out.println(array.findMin(nums));
	}

}
