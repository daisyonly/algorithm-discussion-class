package july_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

import tree.TreeNode;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans= new ArrayList<Integer>();
		bfs(root,ans);		
		return ans;
        
    }

	private void bfs(TreeNode root, List<Integer> ans) {
		// TODO Auto-generated method stub
		if (root==null) return;
		Queue<TreeNode> que= new LinkedList<TreeNode>();
		que.offer(root);
		while (!que.isEmpty()) {
			int length=que.size();
			for(int i=0;i<length;i++){
				TreeNode peekNode= que.poll();
				if(i==length-1) ans.add(peekNode.val);
				if(peekNode.left!=null) que.offer(peekNode.left);
				if(peekNode.right!=null) que.offer(peekNode.right);
			}
		}
	}

}
