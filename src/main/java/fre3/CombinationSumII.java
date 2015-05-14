package fre3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
	
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    List<List<Integer>> ansList = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		List<Integer> tmp = new LinkedList<Integer>();
		findAns(ansList,tmp,0,candidates,target);		 
		return ansList;
	        
   }
   
   private void findAns(List<List<Integer>> ansList, List<Integer> tmp, int start,
			int[] candidates,int target) {
		if(target<0) return;
		if(target==0){
			ansList.add(new LinkedList<Integer>(tmp));
			return;
		}
		for(int i=start;i<candidates.length;i++){
			if(i>start && candidates[i]==candidates[i-1]) continue; 
			tmp.add(candidates[i]);
			findAns(ansList, tmp, i+1, candidates, target- candidates[i]);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII a =new CombinationSumII();
		int[] candidates ={1,1};
		System.out.println(a.combinationSum2(candidates, 2));
		

	}

}
