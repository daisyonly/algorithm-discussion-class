package july_10;

import java.util.Arrays;

import tree.TreeNode;

public class CountCompleteTreeNodes {
	
	public static int countNodes(TreeNode root) {
		if(root ==null) return 0;
		int left=0,right=0;
		TreeNode leftNode=root,rightNode=root;
		while(leftNode!=null){
			left++;
			leftNode=leftNode.left;
		}
		while(rightNode!=null){
			right++;
			rightNode=rightNode.right;
		}
		System.out.println(left);
		System.out.println(2<<(left-1));
		
		if(right==left) {
			int tmp = 2<<(left-1);
			return tmp-1;
		}
		return 1+countNodes(root.left)+countNodes(root.right);
        
    }
	public int findKthLargest(int[] nums, int k) {
       final int N = nums.length;
       Arrays.sort(nums);
       return nums[N - k];
       
   }
	public static void main(String[] args) {
		TreeNode root = TreeNode.deserializeTree("[1]");
		int ans = CountCompleteTreeNodes.countNodes(root);
		System.out.println(ans);
	}

}
