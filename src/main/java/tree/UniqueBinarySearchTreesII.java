package tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
	    List<ArrayList<TreeNode>> list = new ArrayList<ArrayList<TreeNode>>();
	    ArrayList<TreeNode> zero = new ArrayList<TreeNode>();
	    zero.add(null);
	    list.add(0, zero); 
	    for(int i=1; i<=n; i++){
	    	ArrayList<TreeNode> tmp =  new ArrayList<TreeNode>();
	    	for(int j=1; j<=i; j++){
	    		ArrayList<TreeNode> leftTreeList = list.get(j-1);
	    		ArrayList<TreeNode> rightTreeList = list.get(i-j);
	    		for(int ii = 0; ii<leftTreeList.size();ii++){
	    			for(int jj = 0; jj<rightTreeList.size(); jj++){
	    				TreeNode node = new TreeNode(j);
	    				node.left = leftTreeList.get(ii);
	    				node.right = addRightNode(rightTreeList.get(jj),j);
	    				tmp.add(node);
	    			}
	    		}
	    	}
	    	list.add(i, tmp);
	    }    	
    	return list.get(n);        
    }

	private TreeNode addRightNode(TreeNode node,int j) {
		if(node == null){
			return null;
		}
		TreeNode newNode = new TreeNode(node.val + j);
		newNode.left = addRightNode(node.left,j);
		newNode.right = addRightNode(node.right,j);
		return newNode;
	}
	
	public static void main(String[] args){
		UniqueBinarySearchTreesII a= new UniqueBinarySearchTreesII();
		System.out.println(a.generateTrees(2));
		ArrayList<TreeNode> aa = new ArrayList<TreeNode>();
		aa.add(null);
		System.out.println(aa);
		System.out.println(new Object());
	}

}
