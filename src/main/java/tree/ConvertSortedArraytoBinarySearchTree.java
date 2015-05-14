package tree;


//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArraytoBinarySearchTree {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null||nums.length==0) return null;
		return dfs(0,nums.length-1,nums);        
    }

	private TreeNode dfs(int left, int right, int[] nums) {
		// TODO Auto-generated method stub
		if(left>right) return null;
		int mid = (left+right)>>1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(left, mid-1, nums);
		root.right = dfs(mid+1, right, nums);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
