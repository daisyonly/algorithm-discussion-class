package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLinkNode {
	
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
    public static TreeLinkNode deserializeTree(String s){
		
    	s = s.substring(1,s.length()-1);
    	String[] strs = s.split(",");
    	if(strs.length==0)
    		return null;
    	
    	Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
    	TreeLinkNode root = new TreeLinkNode(Integer.parseInt(strs[0])); 
    	q.add(root);
    	int i=1;
    	while(!q.isEmpty()){
    		TreeLinkNode n = q.poll();
    		if(i< strs.length && !strs[i].equals("#")){
    			TreeLinkNode left = new TreeLinkNode(Integer.parseInt(strs[i]));
    			n.left=left;
    			//System.out.println(strs[i]);
    			q.add(left);   			
    		}
    		i++;
			if(i<strs.length && !strs[i].equals("#")){
				TreeLinkNode right = new TreeLinkNode(Integer.parseInt(strs[i]));
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
