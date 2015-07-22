package july;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ans = new LinkedList<String>();
		if(nums==null||nums.length==0) return ans;
		int start = nums[0];
		int pre = start;
		int count =1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]-nums[i-1]==1){
				count++;
			}else{
				if(count>1) ans.add(start+"->"+nums[i-1]);
				else ans.add(start+"");
				count=1;
				start=nums[i];
			}
		}
		if(count>1) ans.add(start+"->"+nums[nums.length-1]);
		else ans.add(start+"");
		return ans;
	        
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={0,1,2,4,5,7};
		SummaryRanges a = new SummaryRanges();
		System.out.println(a.summaryRanges(nums));

	}

}
