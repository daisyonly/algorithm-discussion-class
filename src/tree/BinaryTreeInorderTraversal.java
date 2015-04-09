package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import week7.TreeNode;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> ans = new LinkedList<Integer>();
    	inorderTraversal(ans,root);
		return ans;
        
    }
    
    //递归
	private void inorderTraversal(List<Integer> ans, TreeNode node) {
		if(node == null) return;
		inorderTraversal(ans,node.left);
		ans.add(node.val);
		inorderTraversal(ans,node.right);		
	}
	
	//迭代
	public List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> ans = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curNode = root;
    	while(curNode!= null || !stack.isEmpty()){
    		while(curNode!=null){
    			stack.add(curNode);
    			curNode = curNode.left;
    		}
    		curNode = stack.pop();
    		ans.add(curNode.val);
    		curNode = curNode.right; 
    	}
		return ans;       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
