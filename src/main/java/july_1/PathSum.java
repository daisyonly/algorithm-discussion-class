package july_1;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
		List<Integer> tmp= new ArrayList<Integer>();
		if(root==null) return false;
    	return dfs(root,tmp,sum);      
    }

	private boolean dfs(TreeNode node, List<Integer> tmp, int sum) {
		// TODO Auto-generated method stub
		tmp.add(node.val);
		if(node.left==null&&node.right==null){
			int count=0;
			for(int num:tmp){
				count+=num;
			}
			if(count==sum) return true;
			return false;
		}
		if(node.left!=null){
			boolean flag=dfs(node.left, tmp, sum);
			if(flag) return true;
			tmp.remove(tmp.size()-1);
		}
		if(node.right!=null){
			boolean flag=dfs(node.right, tmp, sum);
			if(flag) return true;
			tmp.remove(tmp.size()-1);
		}
		return false;
	}

}
