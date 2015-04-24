package fre4;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {
	
	public int removeElement(int[] A, int elem) {
		int count =0;
		for(int i=0;i<A.length;i++){
			if(A[i]!= elem){
				A[count++] = A[i];
			}
		}
		return count;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
