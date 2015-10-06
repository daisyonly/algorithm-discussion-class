package sortingAlgorithm;

import java.util.Arrays;

public class HeapSortOfMe {
	public void buileMaxHeap(int nums[]){
		int startIndex=getParentIndex(nums[nums.length-1]);
		for(int i=startIndex;i>=0;i--){
			maxHeapify(nums,nums.length,i);
		}		
	}
	
	public void heapSort(int nums[]){
		buileMaxHeap(nums);
		for(int i=nums.length-1;i>0;i--){
			int tmp=nums[0];
			nums[0]=nums[i];
			nums[i]=tmp;
			maxHeapify(nums, i, 0);
		}
	}

	private void maxHeapify(int[] nums, int heapSize, int index) {
		int leftIndex=getLeftIndex(index);
		int rightIndex=getRightIndex(index);
		int largeIndex=index;
		if(leftIndex<heapSize && nums[largeIndex]<nums[leftIndex]){
			largeIndex=leftIndex;
		}
		if(rightIndex<heapSize && nums[largeIndex]<nums[rightIndex]){
			largeIndex=rightIndex;
		}
		if(largeIndex!=index){
			int tmp=nums[index];
			nums[index]=nums[largeIndex];
			nums[largeIndex]=tmp;
			maxHeapify(nums, heapSize, largeIndex);
		}		
	}

	private int getRightIndex(int x) {
		return (x<<1)+2;
	}

	private int getLeftIndex(int x) {
		return (x<<1)+1;
	}

	private int getParentIndex(int x) {
		return (x-1)>>1;
	}
	
	public static void main(String[] args) {
		HeapSortOfMe institute= new HeapSortOfMe();
		int[] sort = new int[]{1,0,10,20,3,5,6,4,9,8,12,17,34,11};
		institute.heapSort(sort);
		System.out.println(Arrays.toString(sort));
		
	}
}