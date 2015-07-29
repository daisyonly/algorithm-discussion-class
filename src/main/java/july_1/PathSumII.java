package july_1;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ansList= new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		if(root==null) return ansList;
		dfs(root,ansList,tmp,sum);
		return ansList;
        
    }

	private void dfs(TreeNode node, List<List<Integer>> ansList,
			List<Integer> tmp,int tar) {
		// TODO Auto-generated method stub
		tmp.add(node.val);
		if(node.left==null&&node.right==null){
			int sum=0;
			for(int num:tmp){
				sum+=num;
			}
			if(sum==tar){
				ansList.add(new ArrayList<Integer>(tmp));
			}
			return;
		}
		if(node.left!=null){
			dfs(node.left, ansList, tmp, tar);
			tmp.remove(tmp.size()-1);
			
		}
		if(node.right!=null){
			dfs(node.right, ansList, tmp, tar);
			tmp.remove(tmp.size()-1);
		}		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumII aIi=new PathSumII();
		

	}

}
