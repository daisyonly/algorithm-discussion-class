package sortingAlgorithm;

import java.util.Random;

public class QuickSort {
	
	public void quickSort(int [] data,int start, int end) {
		if(start >= end) return;
		int index = partition(data,start,end);
		quickSort(data, start, index-1);
		quickSort(data, index+1, end);
	}

	@SuppressWarnings("unused")
	private int partition(int[] data, int start, int end) {
		Random random = new Random();
		int index = random.nextInt(end - start + 1)+ start;
		swap(data, index, end);
		int small = start - 1;
		for(int i = start; i < end; ++i){
			if(data[i]<data[end]){
				++ small;
				if(small != i)  swap(data, small, i);
			}
		}
		swap(data, ++small, end);
		return small;
	}
	private int[] threeWayPartition(int[] data, int start, int end){
		int[] ans = {-1,-1};
		Random random = new Random(); 
		int num = data[random.nextInt(end - start + 1)+ start];
		int small = start-1, big = end+1,i = start;
		while( i < big){
			if(data[i] < num) swap(data, ++small , i++);
			else if(data[i] > num) swap(data, --big, i);
			else ++i;
		}
		ans[0] = small;
		ans[1] = big;
		return ans;	
	}

	private void swap(int[] data,int i, int j) {
		if (i==j) return;
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];	
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,1,9,30,3,7,9};
		QuickSort aQuickSort = new QuickSort();
		aQuickSort.quickSort(A, 0, A.length-1);
		for(int i =0;i<A.length;i++){
			System.out.print(A[i] +" ");
		}
	}
}
