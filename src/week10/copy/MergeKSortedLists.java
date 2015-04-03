package week10.copy;

import java.util.LinkedList;
import java.util.List;

import week3.ListNode;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null ||lists.size()==0) return null;
		return devide(lists,0,lists.size()-1);

	}
	
	private ListNode devide (List<ListNode> lists,int left,int right){
		if(left == right) return lists.get(left);
		int mid = (left+right)/2;
		return merge(devide(lists, left, mid), devide(lists, mid+1, right));
	}

	private ListNode merge(ListNode leftNode, ListNode rightNode) {
		ListNode curLeftNode = leftNode;
		ListNode curRightNode = rightNode;
		ListNode dummy = new ListNode(-1);
		ListNode curNode = dummy;
		while (curLeftNode != null && curRightNode != null) {
			if (curLeftNode.val < curRightNode.val) {
				curNode.next = curLeftNode;
				curLeftNode = curLeftNode.next;
			} else {
				curNode.next = curRightNode;
				curRightNode = curRightNode.next;
			}
			curNode = curNode.next;
		}
		curNode.next = curRightNode == null ? curLeftNode:curRightNode;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = ListNode.generateListNode("1,5,7,10");
		ListNode node2 = ListNode.generateListNode("1,5,7,10");
		ListNode node3 = ListNode.generateListNode("3,6,9,9,11");
		ListNode node4 = ListNode.generateListNode("2,6,9,9,11");
		List<ListNode> list = new LinkedList<ListNode>();
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		MergeKSortedLists aKSortedLists = new MergeKSortedLists();
		System.out.println(aKSortedLists.mergeKLists(list));
	}
}
