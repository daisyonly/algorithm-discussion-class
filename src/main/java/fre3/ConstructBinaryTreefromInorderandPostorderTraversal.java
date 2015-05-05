package fre3;

import java.util.HashMap;

import week7.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	HashMap<Integer, Integer> map;
	int[] postorder;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length==0) return null;
		this.postorder=postorder;
		map = new HashMap<Integer, Integer>();
		for(int i=0;i<inorder.length;i++)map.put(inorder[i], i);
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		dfs(root,0,0,inorder.length);
		return root;     
    }

	private void dfs(TreeNode root, int inStar, int posStar, int length) {
		// TODO Auto-generated method stub
		int index = map.get(root.val);
		if(index > inStar){
			root.left = new TreeNode(postorder[posStar+index-inStar-1]);
		    dfs(root.left, inStar, posStar, index-inStar);
		}
		if(index < inStar+length-1){
			root.right = new TreeNode(postorder[posStar+length-2]);
		    dfs(root.right, index+1, posStar+index-inStar, length-(index-inStar)-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromInorderandPostorderTraversal a= new ConstructBinaryTreefromInorderandPostorderTraversal();
		int inorder[] ={5,7,6,2};
		int postorder[]={5,2,6,7};
		System.out.println(a.buildTree(inorder, postorder));

	}

}
