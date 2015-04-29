package fre3;
//http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
//http://blog.csdn.net/yutianzuijin/article/details/11499917
//https://leetcode.com/problems/median-of-two-sorted-arrays/
//https://leetcode.com/discuss/9265/share-my-simple-o-log-m-n-solution-for-your-reference
public class CopyOfMedianofTwoSortedArrays {

	int findK(int A[], int p1, int B[], int p2, int k) {
		if ((A.length - p1) > (B.length - p2))
			return findK(B, p2, A, p1, k);
		if (p1 == A.length)
			return B[p2 + k - 1];
		if (k == 1)
			return Math.min(A[p1], B[p2]);
		int midA = Math.min(k / 2 + p1, A.length);
		int midB = Math.min(k / 2 + p2, B.length);
		if (A[midA - 1] < B[midB - 1]) {
			int dis = (midA - p1);
			return findK(A, midA, B, p2, k - dis);
		} else {
			int dis = (midB - p2);
			return findK(A, p1, B, midB, k - dis);
		}
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int total= A.length+B.length;
		if(total%2==1){
			return findK(A, 0, B, 0, total/2+1);
		}else{
			return (findK(A, 0, B, 0, total/2)+findK(A, 0, B, 0, total/2+1))*0.5;
		}
	}
}
