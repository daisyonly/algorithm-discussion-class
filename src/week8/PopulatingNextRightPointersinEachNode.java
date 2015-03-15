package week8;


//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersinEachNode {
	
    public void connect(TreeLinkNode root) {
        dfs(root);
    }

	private void dfs(TreeLinkNode node) {
		if(node == null) return;
		if(node.left!= null){
			node.left.next = node.right;
		}
		if(node.next != null && node.right!=null){
			node.right.next= node.next.left;
		}
		dfs(node.left);
		dfs(node.right);
	}

}
