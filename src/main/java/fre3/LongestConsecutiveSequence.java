package fre3;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
       int ans = 1;
       Set<Integer> set = new HashSet<Integer>();
       for(int num:nums){
    	   set.add(num);
       }
       for(int num:nums){
    	   if(!set.contains(num)) continue;
    	   int sum = 1;
    	   set.remove(num);
    	   int tmp = num;
    	   while(set.contains(tmp-1)){
    		   --tmp;
    		   set.remove(tmp);
    		   ++sum;
    	   }
    	   tmp = num;
    	   while(set.contains(tmp+1)){
    		   ++tmp;
    		   set.remove(tmp);
    		   ++sum;
    	   }
    	   ans = sum > ans? sum:ans;
       }
       return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence a = new LongestConsecutiveSequence();
		int num[]= {100, 4, 200, 1, 3, 2};
		System.out.println(a.longestConsecutive(num));

	}

}
