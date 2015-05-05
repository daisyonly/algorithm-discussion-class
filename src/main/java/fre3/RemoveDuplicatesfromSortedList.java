package fre3;

import week3.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next=head;
		ListNode curNode = dummy.next, preNode=dummy;
		while(curNode!=null){
			if(curNode.next!=null&&curNode.val == curNode.next.val){
				preNode.next=curNode.next;
			}else{
				preNode=curNode;
			}
			curNode=curNode.next;
		}		
		return dummy.next;      
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedList a = new RemoveDuplicatesfromSortedList();
		ListNode root = ListNode.generateListNode("1,1,2,3,3");
		System.out.println(a.deleteDuplicates(root));

	}

}
