package fre3;
//http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
//http://blog.csdn.net/yutianzuijin/article/details/11499917
//https://leetcode.com/problems/median-of-two-sorted-arrays/
//https://leetcode.com/discuss/9265/share-my-simple-o-log-m-n-solution-for-your-reference
public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		int total= A.length+B.length;
		if(total%2==1){
			return findK(A, 0, B, 0, total/2+1);
		}else{
			return (findK(A, 0, B, 0, total/2)+findK(A, 0, B, 0, total/2+1))*0.5;
		}
	}

	private int findK(int[] A, int pA, int[] B, int pB, int k) {
		if(A.length-pA>B.length-pB) return findK(B, pB, A, pA, k);
		if(pA == A.length) return B[pB+k-1];
		if(k==1) return Math.min(A[pA], B[pB]);
		int minA = Math.min(k/2+pA, A.length);
		int minB = Math.min(k/2+pB, B.length);
		if(A[minA-1]<B[minB-1]){
			k=k-(minA-pA);
			return findK(A, minA, B, pB, k);
		}else{
			k=k-(minB-pB);
			return findK(A, pA, B, minB, k);
		}
	}
	public static void main(String[] args) {
		MedianofTwoSortedArrays arrays= new MedianofTwoSortedArrays();
		int A[] ={1,2,3,4,5};
		int B[] ={1,2,3,4,6};
		System.out.println(arrays.findMedianSortedArrays(A, B));
	}
}
