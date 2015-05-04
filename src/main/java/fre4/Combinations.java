package fre4;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		boolean flag[] = new boolean[n+1];
		findCombine(1,ans,tmp,flag,n,k);
		return ans;       
    }

	private void findCombine(int cur,List<List<Integer>> ans, LinkedList<Integer> tmp,
			boolean[] flag, int n, int k) {
		if(tmp.size()==k){
			ans.add(new LinkedList<Integer>(tmp));
		}
		for(int i=cur;i<=n;i++){
			if(!flag[i]){
				flag[i]=true;
				tmp.add(i);
				findCombine(i+1,ans, tmp, flag, n, k);
				tmp.remove(tmp.size()-1);
				flag[i]= false;
			}
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations a = new Combinations();
		System.out.println(a.combine(4, 2));

	}

}
