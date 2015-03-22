package week9;

import java.util.ArrayList;
import java.util.List;

import week3.ListNode;
import week7.TreeNode;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertSortedListtoBinarySearchTree {
   private 	List<Integer> list = new ArrayList<Integer>();
   public TreeNode sortedListToBST(ListNode head) {
	  if(head == null) return null;
	  ListNode curNode = head;
	  while(curNode != null){
		  list.add(curNode.val);
		  curNode= curNode.next;
	  }
	  return dfs(0,list.size()-1);        
   }
   private TreeNode dfs(int left, int right) {
	   if(left > right) return null;
	   int mid = (right-left)/2 +left;
	   int aa = list.get(mid);
	   TreeNode node = new TreeNode(aa);
	   node.left = dfs(left, mid-1);
	   node.right = dfs(mid+1, right);
	   return node;
   }
   
   public static void main(String[] args){
	   ConvertSortedListtoBinarySearchTree a = new ConvertSortedListtoBinarySearchTree();
	   ListNode aa = ListNode.generateListNode("3,5,8");	   
	   a.sortedListToBST(aa);
   }

}
