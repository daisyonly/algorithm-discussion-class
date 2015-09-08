package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list =new LinkedList<Integer>();
		int count1=0,can1=0;
		int count2=0,can2=1;
		for(int num:nums){
			if(num==can1){
				count1++;
			}else if(num==can2){
				count2++;
			}else if(count1==0){
				count1=1;
				can1=num;
			}else if(count2==0){
				count2=1;
				can2=num;
			}else {
				count1--;
				count2--;
			}			
		}
		count1=0;count2=0;
		for(int num:nums){
			if(num==can1) count1++;
			if(num==can2) count2++;
		}
		if(count1>nums.length/3) list.add(can1);
		if(count2>nums.length/3) list.add(can2);		
		
		return list;
        
    }
	
	 public List<Integer> majorityElement2(int[] nums){
	        List<Integer> rst = new ArrayList<Integer>();
	        if(nums == null || nums.length == 0) return rst;
	        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
	        for(int num : nums){
	            if(num == candidate1) count1++;
	            else if(num == candidate2) count2++;
	            else if(count1 == 0){
	                candidate1 = num;
	                count1 = 1;
	            }
	            else if(count2 == 0){
	                candidate2 = num;
	                count2 = 1;
	            }
	            else{
	                count1--;
	                count2--;
	            }
	        }
	        count1 = 0; count2 = 0;
	        for(int num : nums){
	            if(num == candidate1) count1+=2;
	            else count1--;
	            if(num == candidate2) count2 += 2;
	            else count2--;
	        }
	        if(count1 > 0) rst.add(candidate1);
	        if(count2 > 0) rst.add(candidate2);
	        return rst;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={0,0,0};
		MajorityElementII test=new MajorityElementII();
		System.out.println(test.majorityElement2(nums));

	}

}
