package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
    public static TreeNode deserializeTree(String s){
		
    	s = s.substring(1,s.length()-1);
    	String[] strs = s.split(",");
    	if(strs.length==0)
    		return null;
    	
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	TreeNode root = new TreeNode(Integer.parseInt(strs[0])); 
    	q.add(root);
    	int i=1;
    	while(!q.isEmpty()){
    		TreeNode n = q.poll();
    		if(i< strs.length && !strs[i].equals("#")){
    			TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
    			n.left=left;
    			//System.out.println(strs[i]);
    			q.add(left);   			
    		}
    		i++;
			if(i<strs.length && !strs[i].equals("#")){
				TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
				n.right=right;
    			q.add(right);
			}
			i++;
    	}   	
    	return root;   	  	
    }
    public static void main(String[] args){
    	TreeNode node = TreeNode.deserializeTree("{1,2,3,#,#,4,#,#,5}");
    	System.out.println(node);
    }
}
