package july_1;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		int num1=0,num2=0;
		int count1=0,count2=0;
		for(int i=0;i<nums.length;i++){
			if(count1==0||nums[i]==num1){
				count1++;
				num1=nums[i];
			}else if(count2==0 || nums[i]==num2){
				count2++;
				num2=nums[i];
			}else{
				count1--;
				count2--;
			}
		}
		count1=0;
		count2=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==num1) count1++;
			else if(nums[i]==num2) count2++;
		}
		List<Integer> ans = new LinkedList<Integer>();
		if(count1>nums.length/3) ans.add(num1);
		if(count2>nums.length/3) ans.add(num2);		
		return ans;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
