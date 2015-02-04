package week2;

public class RemoveDuplicatesfromSortedArrayII {
	
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) return 0;
        int ans=1;
        int tmp=1;
        int count=1;
        for(int i = 1; i < A.length; i++){
        	if(A[i]==A[i-1]){
        		count++;
        		if(count <= 2) {
        			A[tmp++] = A[i];
        			ans++;
        		}        			
        	}else {
        		A[tmp++]=A[i];
        		ans++;
        		count=1;
			}
        }        
        return ans;
    }
	
	public int removeDuplicates2(int[] A) {
		if(A.length<=2) return A.length;
        int index=2;
        for(int i=2; i<A.length;i++){
           if(A[i] != A[index-2]) A[index++] = A[i];	
        }          
        return index;
    }
	
	
	public int removeDuplicates3(int[] A) {
		int index = 0;
		int n = A.length;
		for (int i = 0; i < n; ++i) {
			if (i > 0 && i < n - 1 && A[i] == A[i - 1] && A[i] == A[i + 1])
				continue;
			A[index++] = A[i];
		}
		return index;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII tmp= new RemoveDuplicatesfromSortedArrayII();
		int[] A= {1,1,1,2,2,3};
		System.out.println(tmp.removeDuplicates3(A));
		// TODO Auto-generated method stub

	}

}
