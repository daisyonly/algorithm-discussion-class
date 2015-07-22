package july_1;
import tree.TreeNode;

public class InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
		if(root==null) return root;
		TreeNode leftNode =invertTree(root.left);
		TreeNode rightNode = invertTree(root.right);
		root.right=leftNode;
		root.left=rightNode;  	
    	return root;      
    }

}
