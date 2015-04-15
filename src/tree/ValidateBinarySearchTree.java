package tree;

import java.util.ArrayList;
import java.util.List;

import week7.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	dfs(list,root);
    	if(list.size()==0 || list.size() ==1) return true;
    	else{
    		for(int i=1;i<list.size();i++){
    			if(list.get(i)<=list.get(i-1)) return false;
    		}
    	}
    	return true;
    }

	private void dfs(List<Integer> list,TreeNode node) {
		if(node == null) return;
		dfs(list, node.left);
		list.add(node.val);
		dfs(list, node.right);
	}
	/*
	 * bool validate(TreeNode* node, TreeNode* &prev) {
        if (node == NULL) return true;
        if (!validate(node->left, prev)) return false;
        if (prev != NULL && prev->val >= node->val) return false;
        prev = node;
        return validate(node->right, prev);
    }
	 */
	public static void main(String[] args) {
		TreeNode rooTreeNode = TreeNode.deserializeTree("{3,1,5,0,2,4,6,#,#,#,3}");
		ValidateBinarySearchTree a = new ValidateBinarySearchTree();
		boolean ans = a.isValidBST(rooTreeNode);
		System.out.print(ans);
	}

}
