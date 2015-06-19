package inter_prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CopyOfDuplicatesPermutation {
	 public List<List<Integer>> permuteUnique(int[] num) {
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			List<Integer> tmp = new LinkedList<Integer>();
			Map<List<Integer>, Boolean> map = new HashMap<List<Integer>, Boolean>();
			Map<Integer, Boolean> flag = new HashMap<Integer, Boolean>();
			for(int i=0;i<num.length;i++){
				flag.put(i, false);
			}
			Arrays.sort(num);
			findPermutations(ans,tmp,num,map,flag);
			return ans;        
	    }

		private void findPermutations(List<List<Integer>> ans, List<Integer> tmp,
				int[] num, Map<List<Integer>, Boolean> map,Map<Integer, Boolean> flag) {
			if(tmp.size()==num.length){
				if(map.containsKey(tmp)==false){
					map.put(tmp, true);
					ans.add(new ArrayList<>(tmp));
				}
				return;
			}
			for(int i=0;i<num.length;i++){
				if(flag.get(i)==false){
					flag.put(i, true);
					tmp.add(num[i]);
					findPermutations(ans, tmp, num, map, flag);
					tmp.remove(tmp.size()-1);
					flag.put(i, false);
				}
			}			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOfDuplicatesPermutation test = new CopyOfDuplicatesPermutation();
		int[] num = {3,3,0,0,2,3,2};
		System.out.println(test.permuteUnique(num));
		System.out.println(test.permuteUnique(num).size());

	}

}
