package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class SubsetsIIMine {
	
	public List<List<Integer>> subsetsWithDup2(int[] num) {
		Arrays.sort(num);;
		List<List<Integer>> ansList = new ArrayList<List<Integer>>();
		ansList.add(new ArrayList<Integer>());
		int preSize=1;
		for(int i=0;i<num.length;i++){
			int curSize = ansList.size();
			int begin = preSize;
			preSize = curSize;
			if( i>0&& num[i]==num[i-1]){
				for(int j = begin; j < curSize; j++){
					ArrayList<Integer> tmp = new ArrayList<Integer>(ansList.get(j)); 
					tmp.add(num[i]);
					ansList.add(tmp);
				}
			}else{
				for(int j = 0; j < curSize; j++){
					ArrayList<Integer> tmp = new ArrayList<Integer>(ansList.get(j)); 
					tmp.add(num[i]);
					ansList.add(tmp);
				}
			}
		}
		return ansList;   
	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);;
		List<List<Integer>> ansList = new LinkedList<List<Integer>>();
		LinkedList<Integer> tmp = new LinkedList<Integer>(); 
		dfs(ansList,tmp,num,0);
		return ansList;
	   
	}	
	
	private void dfs(List<List<Integer>> ansList, LinkedList<Integer> tmp, int[] num,
			int index) {
		ansList.add(new LinkedList<Integer>(tmp));
		for(int i=index;i<num.length;i++){
			if(i==index || num[i]!= num[i-1]){
				tmp.add(num[i]);
				dfs(ansList, tmp, num, i+1);
				tmp.pollLast();
			}
		}		
	}

	public static void main(String[] args) {
		SubsetsIIMine aSubsets = new SubsetsIIMine();
		int[] S = {1,2,2};
		System.out.println(aSubsets.subsetsWithDup2(S));
	}

}
