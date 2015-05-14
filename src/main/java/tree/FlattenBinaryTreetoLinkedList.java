package tree;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if(root==null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode dummy = new TreeNode(-1);
        TreeNode preNode = dummy;
        while(!st.empty()){
        	TreeNode top = st.pop();
        	if(top.right!=null) st.push(top.right);
        	if(top.left != null) st.push(top.left);
        	preNode.left=null;
        	preNode.right=top;
        	preNode = top;
        }      
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
