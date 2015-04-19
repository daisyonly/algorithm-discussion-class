package week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			map.put(numbers[i], i+1);
		}
		for(int i=0;i<numbers.length;i++){
			if(map.get(target-numbers[i])!=null && map.get(target-numbers[i])!=(i+1)){
				ans[0] = i+1;
				ans[1] = map.get(target-numbers[i]);
				break;
			}
		}
		return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
