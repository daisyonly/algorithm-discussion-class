package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) return ans;
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> tmp = new LinkedList<Integer>();
			for(int i=0;i<size;i++){
				TreeNode peek = queue.poll();
				if(peek.left!=null) queue.offer(peek.left);
				if(peek.right!=null) queue.offer(peek.right);
				tmp.add(peek.val);
			}
			ans.add(tmp);
		}		
		return ans;		   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal a = new BinaryTreeLevelOrderTraversal();
		TreeNode root = TreeNode.deserializeTree("{3,9,20,#,#,15,7}");
		System.out.println(a.levelOrder(root));

	}

}
