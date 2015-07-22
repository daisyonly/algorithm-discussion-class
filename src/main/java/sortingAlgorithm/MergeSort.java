package sortingAlgorithm;

public class MergeSort {
	public static void mergeSort(int nums[]){
		if(nums==null||nums.length==0) return;
		divider(nums,0,nums.length-1);
	}

	private static void divider(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		if(right<=left) return;
		int mid=left+((right-left)>>1);
		divider(nums, left, mid);
		divider(nums, mid+1, right);
		merge(nums,left,right);
		
	}

	private static void merge(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		int tmp[]= new int[right-left+1];
		int k=0,i=left;
		int mid=left+((right-left)>>1);
		int j=mid+1;
		while(i<=mid&&j<=right){
			if(nums[i]<=nums[j]){
				tmp[k++]=nums[i++];
			}else{
				tmp[k++]=nums[j++];
			}
		}
		while(i<=mid){
				tmp[k++]=nums[i++];
		}
		while(j<=right){
				tmp[k++]=nums[j++];
		}
		i=left;k=0;
		for(;i<=right;i++){
			nums[i]=tmp[k++];
			//System.out.print(nums[i]+" ");
		}
		//System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubsta
		int nums[]={2,1,3,-1,0};
		MergeSort.mergeSort(nums);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}

	}

}
