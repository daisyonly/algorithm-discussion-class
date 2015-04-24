package week12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/permutations/
public class Permutations {
	
	//不重复的集合求全排列
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		List<Integer> tmp = new LinkedList<Integer>();
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Arrays.sort(num);
		for(int i=0;i<num.length;i++){
			map.put(i, false);
		}
		findPermutations(ans,tmp,num,map);
		return ans;
        
    }

	private void findPermutations(List<List<Integer>> ans, List<Integer> tmp,
			int[] num, Map<Integer, Boolean> map) {
		if(tmp.size()== num.length){
			ans.add(new LinkedList<Integer>(tmp));
			return;
		}
		for(int i=0;i<num.length;i++){
			if(!map.get(i)){
				if(i>0 && num[i] == num[i-1] && map.get(i-1)==false) continue;
				map.put(i, true);
				tmp.add(num[i]);
				findPermutations(ans, tmp, num, map);
				tmp.remove(tmp.size()-1);
				map.put(i, false);
			}
		}		
	}
	public static void main(String[] args) {
		Permutations a = new Permutations();
		int num[] ={1,1,2};
		List<List<Integer>> ansList = a.permute(num);
		System.out.println("ans:"+ ansList);
	}

}
