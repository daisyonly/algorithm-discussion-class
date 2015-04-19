package week2;

import java.util.Arrays;

public class SumCloset3 {
	
	public int threeSumClosest(int[] num, int target) {
		int ans = num[0]+ num[1]+ num[2];
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++){
			int l = i+1;
			int r = num.length-1;
			while(l<r){
				int sum = num[l]+ num[r] + num[i];
				if(Math.abs(sum-target) < Math.abs(ans-target)){
					ans = sum;
				}
				if(sum>target){
					r--;
				}
				else{
					l++;
				}				
			}
		}
		return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumCloset3 tmp= new SumCloset3();
		int[] num ={1,1,-1};
		int target = 0; 
		System.out.println(tmp.threeSumClosest(num, target));
		

	}

}
