package july_1;

import java.util.Stack;

import tree.TreeNode;

public class BSTIterator {
	TreeNode curNode=null;
	Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        curNode=root;
        stack=new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty()||curNode!=null;
        
    }

    /** @return the next smallest number */
    public int next() {
		while(curNode!=null){
			stack.push(curNode);
			curNode=curNode.left;
		}
		TreeNode ansNode=stack.pop();
		curNode=ansNode.right;	
    	return ansNode.val;
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
