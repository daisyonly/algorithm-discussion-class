package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3 {
	public List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for(int i=0;i<num.length-2;i++){
	    	if(i==0||(i>=0&&num[i]!=num[i-1])){
	    		int left=i+1,right=num.length-1;
	    		int sum=0-num[i];
	    		while(left<right){
	    			if(num[left]+num[right]==sum){
	    				res.add(getList(num[i],num[left],num[right]));
	    				while(left+1<right&&num[left]==num[left+1]) left++;
	    				while(right-1>left&&num[right]==num[right-1]) right--;
	    				left++;
	    				right--;
	    			}else if(num[left]+num[right]<sum){
	    				left++;
	    			}else{
	    				right--;
	    			}
	    		}
	    		
	    	}
	    }
	    return res;
	}
	
	private List<Integer> getList(int num1,int num2,int num3){
		List<Integer> res= new LinkedList<>();
		res.add(num1);
		res.add(num2);
		res.add(num3);
		return res;
	}


}
