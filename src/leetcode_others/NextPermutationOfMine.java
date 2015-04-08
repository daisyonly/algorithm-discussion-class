package leetcode_others;

//https://leetcode.com/problems/next-permutation/
public class NextPermutationOfMine {
	//http://blog.csdn.net/m6830098/article/details/17291259
	//1.从后往前，找到第一个 A[i-1] < A[i]的。也就是第一个排列中的  6那个位置，可以看到A[i]到A[n-1]这些都是单调递减序列。
    //2.从 A[n-1]到A[i]中找到一个比A[i-1]大的值（也就是说在A[n-1]到A[i]的值中找到比A[i-1]大的集合中的最小的一个值）
    //3.交换 这两个值，并且把A[n-1]到A[i]排序，从小到大。
	public void nextPermutation(int[] num) {
	   if(num.length<2) return;
	   int n = num.length;
	   int index = num.length-1;
	   while(index>0 && num[index-1]>=num[index]){
		   index--;
	   }
	   if(index==0){
		   reverse(num,0,n-1);
	   }else{
		   int smallBig = n-1;
		   int val = num[index-1];
		   System.out.println("val:" + val);
		   while( smallBig >= 0 && num[smallBig]<=val){
			   smallBig--;
		   }
		   System.out.println("val:" + num[smallBig]);
		   swap(num, index-1 , smallBig);
		   System.out.println("index:" + index);
		   reverse(num, index, n-1);
	   }
	}

	private void reverse(int[] num, int left, int right) {
		int mid = (left+right)>>1;
		for(int i= left; i <= mid; i++){
			swap(num,i,right+left-i);
		}		
	}

	private void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;		
	}
	public static void main(String[] args) {
		NextPermutationOfMine aMine= new NextPermutationOfMine();
		int[] num = {1,3,2};
		aMine.nextPermutation(num);
		for(int i:num){
			System.out.print(i +"  ");
		}
	}

	

}
