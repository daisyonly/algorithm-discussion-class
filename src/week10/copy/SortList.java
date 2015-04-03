package week10.copy;

import week3.ListNode;

//https://leetcode.com/problems/sort-list/
public class SortList {
    public ListNode sortList(ListNode head) {
		int length = 0;
		ListNode curNode = head;
		while(curNode != null){
			length++;
			curNode = curNode.next;
		}
    	return divide(head,length);       
    }
     
    private ListNode divide(ListNode head,int length) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode tmp = go(head,length/2-1);
		ListNode righthead = tmp.next;
		tmp.next = null;
		ListNode leftNode = divide(head,length/2);
		ListNode rightNode = divide(righthead, length-length/2);
		return merge(leftNode, rightNode);
	}

	private ListNode go(ListNode node, int length) {
		ListNode  tmp = node;
		while(length!=0){
			tmp = tmp.next;
			length--;
		}
		return tmp;
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
		ListNode head = ListNode.generateListNode("2,1,4");
		SortList a = new SortList();
		System.out.println(a.sortList(head));
	}

}
