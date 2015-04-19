package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> result = new LinkedList<List<Integer>>();
	    LinkedList<Integer> temp = new LinkedList<Integer>();
	    Rec(num,result,temp,0);
	    return result;
	}
	
	//用current来标记上一轮有没有加过，也就是说当a[i] == a[i-1]的情况下，只有上一轮被加过的元素才可以继续加，否则不加；
	//和第一题不一样的是，不是只有递归到叶节点在增加结果！！！
	//current表示当前已经处理的节点的下标，i表示当前要加入集合的整数的下标；
	//只有当（当前temp中的节点数 == 要加入的整数的下标）或者（要加入整数不是重复元素）才加入；
	//根据树遍历的顺序，只有左节点的current == i
	private void Rec(int[] a,List<List<Integer>> result, LinkedList<Integer> temp, int current){    
		result.add(new LinkedList<Integer>(temp));
	    for(int i = current;i<a.length;i++){
	        if(i == current || a[i] != a[i-1]){
	            temp.add(a[i]);
	            Rec(a,result,temp,i+1);
	            temp.pollLast();
	        }
	    }
	    return;
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num); // for test case
        
        for(int length=0; length<=num.length; length++) // different length of subsets
        // use one array list to compute all the possible subsets at certain length
        helper(num, rs, new ArrayList<Integer>(), length, 0);  
        return rs;
    }
    
    public void helper(int[] num, ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> subSet, int length, int startPoint){
        if(length == subSet.size()){// one possible subset constructed
            rs.add(new ArrayList<Integer>(subSet));
        }
        else{ 
            for(int i=startPoint; i<num.length; i++){// switch current element
                subSet.add(num[i]);
                helper(num, rs,subSet, length, i+1); // throw the remaining elements to recursive call
                subSet.remove(subSet.size()-1); // remove the current element and try the next element
                // only non-duplicate element would be chosen as current element
                while (i<num.length-1 && num[i+1] == num[i]) i++; 
            }
        }
    }
	
	public static void main(String[] args) {
		SubsetsII aSubsets = new SubsetsII();
		int[] S = {1,2,2};
		System.out.println(aSubsets.subsetsWithDup(S));
	}

}
