package july;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	 public String largestNumber(int[] nums) {
		 Comparator<String> comp = new Comparator<String>(){
		        @Override
		        public int compare(String str1, String str2){
		            String s1 = str1+str2;
		            String s2 = str2+str1;
		            return s1.compareTo(s2);
		        }
		    };
		   String numstoString[]= new String[nums.length];
		   for(int i=0;i<nums.length;i++){
			   numstoString[i]=nums[i]+"";
		   }
	       Arrays.sort(numstoString,comp); 
	       for(int i=0;i<numstoString.length;i++){
	    	   System.out.print(numstoString[i]+"  ");
	       }
	       StringBuilder ans = new StringBuilder();
	       for(int i=0;i<numstoString.length;i++){
	    	   ans.append(numstoString[i]);
	       }
	       return ans.toString();
	
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="5432";
		String s2="543";
		System.out.println(s1.compareTo(s2));
		int nums[] ={3, 30, 34, 5, 9};
		LargestNumber a = new LargestNumber();
		System.out.println(a.largestNumber(nums));

	}

}
