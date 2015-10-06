package august;

public class LargestNumber {
	
	public String largestNumber(int[] nums) {
		mergeSort(nums,0, nums.length-1);
		StringBuilder sb=new StringBuilder();
		for(int num:nums){
			sb.append(num);
		}
		if(sb.charAt(0) =='0') return "0";
		return sb.toString();        
    }

	private void mergeSort(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		if(left>=right) return;
		int mid=(left+right)/2;
		mergeSort(nums,left,mid);
		mergeSort(nums,mid+1,right);
		merge(nums,left,right);
		
	}

	private void merge(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		int mid=(left+right)/2;
		int index1=left,index2=mid+1;
		int k=0;
		int tmp[]=new int[right-left+1];
		while(index1<=mid&&index2<=right){
			boolean flag=compare(nums[index1],nums[index2]);
			if(flag){
				tmp[k++]=nums[index1++];
			}else{
				tmp[k++]=nums[index2++];
			}
		}
		while(index1<=mid){
			tmp[k++]=nums[index1++];
		}
		while(index2<=right){
			tmp[k++]=nums[index2++];
		}
		k=0;
		for(int i=left;i<=right;i++){
			nums[i]=tmp[k++];
		}
		
	}
    //if a>b return true;
	private boolean compare(int a, int b) {
		// TODO Auto-generated method stub
		String aString=a+""+b;
		String bString=b+""+a;
		for(int i=0;i<aString.length();i++){
			if(aString.charAt(i)>bString.charAt(i)) return true;
			else if(aString.charAt(i)<bString.charAt(i)) return false;
		}
		return false;
	}
	public static void main(String[] args) {
		LargestNumber test=new LargestNumber();
		int[] nums={121,12};
		System.out.println(test.largestNumber(nums));
	
	}

}
