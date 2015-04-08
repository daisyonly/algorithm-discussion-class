package leetcode_others;

import week3.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(-1);
    	ListNode curNode = dummy;
		while(l1!=null && l2 !=null){
			if(l1.val <= l2.val){
				curNode.next=l1;
				l1=l1.next;
			}else {
			    curNode.next=l2;
			    l2=l2.next;
			}
			curNode=curNode.next;
		}
    	curNode.next = l1==null? l2:l1; 
    	return dummy.next;       
    }

}
