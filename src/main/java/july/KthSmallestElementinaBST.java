package july;

import fre3.FindMinimuminRotatedSortedArray;
import tree.TreeNode;

public class KthSmallestElementinaBST {
	int ans;
	int count;
	
	public int kthSmallest(TreeNode root, int k) {
		count = k;
		find(root);
		return ans;
        
    }

	private void find(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null) return;
		find(node.left);
		if(count>0){
			count--;
			if(count==0){
				ans=node.val;
				return;
			}
		}
		find(node.right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
