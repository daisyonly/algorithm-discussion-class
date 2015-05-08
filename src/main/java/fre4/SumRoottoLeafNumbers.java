package fre4;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

public class SumRoottoLeafNumbers {
	
	public int sumNumbers(TreeNode root) {
		if(root==null) return 0;
		List<Integer> nums = new LinkedList<>();
		StringBuilder tmp = new StringBuilder();
		findNum(nums,tmp,root);
		int sum=0;
		for(int num:nums){
			System.out.println(num);
			sum +=num;
		}
		return sum;
        
    }

	private void findNum(List<Integer> nums, StringBuilder tmp,TreeNode node) {
		// TODO Auto-generated method stub
		tmp.append(node.val);
		if(node.right == null && node.left ==null){
			int num = Integer.parseInt(tmp.toString());
			nums.add(num);
			return;
		}
		if(node.left!=null){
			findNum(nums, tmp, node.left);
			tmp.deleteCharAt(tmp.length()-1);
		} 
		if(node.right!=null){
			findNum(nums, tmp, node.right);
			tmp.deleteCharAt(tmp.length()-1);
		} 
	}
	
	public int sumNumbers2(TreeNode root) {
	    return sum(root, 0);
	}

	public int sum(TreeNode n, int s){
	    if (n == null) return 0;
	    if (n.right == null && n.left == null) return s*10 + n.val;
	    return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRoottoLeafNumbers  a = new SumRoottoLeafNumbers();
		TreeNode root = TreeNode.deserializeTree("{1,2,3}");
		System.out.println(a.sumNumbers(root));

	}

}
