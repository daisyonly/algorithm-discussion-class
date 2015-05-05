package fre3;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchinRotatedSortedArrayII {
	
	public boolean search(int[] nums, int target) {
		int right = nums.length-1,left=0;
		while(left<=right){
			int mid = (left+right)>>1;
		    if(nums[mid]==target) return true;
		    if(nums[mid] > nums[left]){
		    	if(nums[left] <= target && nums[mid]>target){
		    		right=mid-1;
		    	}else{
		    		left=mid+1;
		    	}
		    }else if(nums[mid] < nums[left]){
		    	if(nums[right] >= target && nums[mid]<target){
		    		left= mid+1;
		    	}else{
		    		right=mid-1;
		    	}
			}else left++;
		}		
		return false;     
    }
	//反例[3,1], 1
	public boolean search3(int[] nums, int target) {
		int right = nums.length-1,left=0;
		while(left<=right){
			int mid = (left+right)>>1;
		    if(nums[mid]==target) return true;
		    if(nums[mid] > nums[left]){
		    	if(nums[left] <= target && nums[mid]>target){
		    		right=mid-1;
		    	}else{
		    		left=mid+1;
		    	}
		    }else{
		    	if(nums[right] >= target && nums[mid]<target){
		    		left= mid+1;
		    	}else{
		    		right=mid-1;
		    	}
			}
		}		
		return false;     
    }
	
	
	public boolean search2(int A[], int key) {
	    int l = 0, r = A.length - 1;
	    while (l <= r) {
	        int m = l + (r - l)/2;
	        if (A[m] == key) return true; //return m in Search in Rotated Array I
	        if (A[l] < A[m]) { //left half is sorted
	            if (A[l] <= key && key < A[m])
	                r = m - 1;
	            else
	                l = m + 1;
	        } else if (A[l] > A[m]) { //right half is sorted
	            if (A[m] < key && key <= A[r])
	                l = m + 1;
	            else
	                r = m - 1;
	        } else l++;
	    }
	    return false;
	}
	public static void main(String[] args) {
		SearchinRotatedSortedArrayII a = new SearchinRotatedSortedArrayII();
		int[] nums ={1,3,1,1,1};
		int target =3;
		System.out.println(a.search3(nums, target));
	}

}
