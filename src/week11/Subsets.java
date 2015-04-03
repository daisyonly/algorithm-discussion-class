package week11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets {
	
    public List<List<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
		List<List<Integer>> ansList = new LinkedList<List<Integer>>();
		ansList.add(new LinkedList<Integer>());
    	for(int i=0; i<S.length; i++){
    		int listSize = ansList.size();
    		for(int j=0;j<listSize;j++){
    			List<Integer> tmp = new LinkedList<Integer>(ansList.get(j));
    			tmp.add(S[i]);
    			ansList.add(tmp);
    		}
    	}
    	return ansList;      
    }
    public List<List<Integer>> subsets2(int[] S) {
    	Arrays.sort(S);
		List<List<Integer>> ansList = new LinkedList<List<Integer>>();
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		dfs(ansList,S,tmp,0);   	
    	return ansList;      
    }
    
	private void dfs(List<List<Integer>> ansList, int[] s,
			LinkedList<Integer> tmp, int i) {
		if(i == s.length){
			LinkedList<Integer> tmpList = new LinkedList<Integer>(tmp);
			ansList.add(tmpList);
			return;
		}
		tmp.add(s[i]);
		dfs(ansList, s, tmp, i+1);
		tmp.pollLast();
		dfs(ansList, s, tmp, i+1);	
	}
	
	public static void main(String[] args) {
		Subsets aSubsets = new Subsets();
		int[] S = {1,2,3};
		System.out.println(aSubsets.subsets2(S));
	}
}
