package week8;

public class PopulatingNextRightPointersinEachNodeII2 {
	
	private TreeLinkNode findNextNode(TreeLinkNode node){
		if(node != null){
			if(node.left != null) return node.left;
			else if(node.right != null) return node.right;
			else{
				return findNextNode(node.next);
			}
		}
		return null;   	
    }
	
	 public void connect(TreeLinkNode root) {
	     TreeLinkNode levelFirstNode = root;
	     TreeLinkNode curLinkNode = root;
	     while(levelFirstNode != null){
	    	 while(curLinkNode!= null){
	    		 if(curLinkNode.left!= null){
		    		 if(curLinkNode.right!=null) curLinkNode.left.next = curLinkNode.right;
		    		 else curLinkNode.left.next = findNextNode(curLinkNode.next);
		    	 }
		    	 if(curLinkNode.right!= null){
		    		 curLinkNode.right.next = findNextNode(curLinkNode.next);
		    	 }
		    	 curLinkNode = curLinkNode.next;
	    	 }
	    	 levelFirstNode = findNextNode(levelFirstNode);
	    	 curLinkNode = levelFirstNode;
	     }
	 }
	 public static void main(String[] args){
	    	TreeLinkNode node = TreeLinkNode.deserializeTree("{1,2}");
	    	PopulatingNextRightPointersinEachNodeII2 aa = new PopulatingNextRightPointersinEachNodeII2();
	    	aa.connect(node);
	    	System.out.println(node);
	    }

}
