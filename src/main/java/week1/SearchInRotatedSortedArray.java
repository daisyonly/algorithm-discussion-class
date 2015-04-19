package week1;

public class SearchInRotatedSortedArray {
	
	public static int search(int[] A, int target) {
		int ans = -1;
		if(A == null || A.length == 0){
			return ans;
		}
		int l = 0;
		int r = A.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(A[m] == target){
				ans = m;
				break;
			}
			if(A[l] <= A[m]){
				if(A[l]<=target && target <= A[m]){
					r=m-1;
				}
				else{
					l=m+1;
				}					
			}
			else{
				if(A[m] <= target && target <= A[r]){
					l=m+1;
				}
				else{
					r=m-1;
				}				
			}			
		}
		return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,1};
		int target =1;
		System.out.println(search(A,target));

	}

}
