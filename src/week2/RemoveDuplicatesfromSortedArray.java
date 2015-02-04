package week2;

public class RemoveDuplicatesfromSortedArray {
	
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) return 0;
		int ans=1;
		int tmp=1;
		for(int i = 1; i < A.length; i++){
			if(A[i]!=A[i-1]){
				ans++;
				A[tmp++]=A[i];
			} 
		}
		return ans;
	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
