package practice;


public class FindEle {
	public int find(int nums[]){
		int left=0,right=nums.length-1;
		while(left<=right){
			int mid=(left+right)/2;
			boolean leftflag=false,rightflag=false;
			if((mid-1>=0&&nums[mid]>=nums[mid-1])
					|| mid == 0) leftflag=true;
			if((mid+1<=nums.length-1&&nums[mid]>=nums[mid+1])
					|| mid == nums.length-1) rightflag=true;
			
			if(leftflag&&rightflag) return nums[mid];
			else if(!leftflag){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={5,4,3,2,1};
		System.out.println(new FindEle().find(nums));

	}

}
