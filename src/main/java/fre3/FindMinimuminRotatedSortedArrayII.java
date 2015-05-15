package fre3;

/*
 * 
 * Input:	[10,1,10,10,10]
Output:	10
Expected:	1
 */
public class FindMinimuminRotatedSortedArrayII {
	 public int findMin(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int left=0,right=nums.length-1;
		while(left<right){
			int mid =(left+right)>>1;
		    if(nums[mid]<nums[right]){
		    	right=mid;
		    }else if(nums[mid]>nums[right]){
				left= mid+1;
			}else {
				right--;
			}
		}
		return nums[left];
	        
	 }
	 
	 public int findMin2(int[] nums) {
			if(nums==null||nums.length==0) return 0;
			int left=0,right=nums.length-1;
			while(left < right){
				int mid =(left+right)>>1;
			    if(nums[mid]<nums[right]){
			    	right=mid;
			    }else if(nums[mid]>nums[right]){
					left= mid+1;
				}else {
					right--;
				}
			}
			return nums[left];
		        
		 }
	 public static void main(String[] args) {
		 FindMinimuminRotatedSortedArrayII a = new FindMinimuminRotatedSortedArrayII();
		 int nums[]={10,10,10,10,1};
		 System.out.println(a.findMin(nums));
	 }

}
