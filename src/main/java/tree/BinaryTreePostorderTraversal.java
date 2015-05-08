package tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans =  new LinkedList<Integer>();     
        Stack<TreeNode> nodeSt =  new Stack<TreeNode>();        
        if (root ==null) return ans;
        TreeNode node = root;
        nodeSt.push(node);
        while(!nodeSt.isEmpty()){
            node = nodeSt.pop();
            //System.out.println(node.val);
            ans.add(0,node.val);
            if(node.left != null){
            	nodeSt.push(node.left);
            }
            if(node.right != null){
            	nodeSt.push(node.right);
            }
        }        
        return ans;    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePostorderTraversal a = new BinaryTreePostorderTraversal();
		TreeNode root = TreeNode.deserializeTree("[1,2]");
		System.out.println(a.postorderTraversal(root));

	}

}
