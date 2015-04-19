package week10;

//https://leetcode.com/problems/search-for-a-range/
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
    	int[] ans = {-1,-1};
		if(A== null || A.length ==0) return ans;
    	int left =0, right=A.length-1;
    	while(left <= right){
    		if(A[left] == target && A[right] == target){
    			ans[0] = left;
    			ans[1] = right;
    			return ans;
    		}
    		int mid = (left + right)/2;
    		if(A[mid] < target){
    			left = mid+1;
    		}else if(A[mid] > target){
    			right = mid-1;
    		}else{
    			if(A[left] != target)
    				left++;
    			else
    				right--;
    		}
    	}
    	return ans;       
    }
    public static void main(String[] args){
    	System.out.println("dhsjkh:");
    	SearchForARange a = new SearchForARange();
    	int[] A = {1,3,4};
    	int [] ans = a.searchRange(A, 1);
    	System.out.println(ans[0]+" "+ans[1]);
    }

}
