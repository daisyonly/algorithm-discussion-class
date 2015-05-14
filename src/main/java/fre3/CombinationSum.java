package fre3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> ansList = new LinkedList<List<Integer>>();
		 Arrays.sort(candidates);
		 List<Integer> tmp = new LinkedList<Integer>();
		 findAns(ansList,tmp,0,candidates,target);		 
		 return ansList;
	        
	 }

	private void findAns(List<List<Integer>> ansList, List<Integer> tmp, int start,
			int[] candidates,int target) {
		if(target<0||start>=candidates.length) return;
		if(target==0){
			ansList.add(new LinkedList<Integer>(tmp));
			return;
		}
		tmp.add(candidates[start]);
		findAns(ansList, tmp, start, candidates, target- candidates[start]);
		tmp.remove(tmp.size()-1);
		findAns(ansList, tmp, start+1, candidates, target);	
	}
	public static void main(String[] args) {
		CombinationSum a = new CombinationSum();
		int[] candidates ={2,3,6,7};
		System.out.println(a.combinationSum(candidates, 7));
		
	}

}
