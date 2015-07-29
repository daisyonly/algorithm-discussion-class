package july_1;

import tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) return null;
		if(root==p||root==q) return root;
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode righNode = lowestCommonAncestor(root.right, p, q);
		if(leftNode!=null&&righNode!=null) return root;
		return leftNode!=null? leftNode:righNode;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
