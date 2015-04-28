package fre3;

import week3.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next=head;
		ListNode cur1 = dummy,cur2=dummy;
		for(int i=0;i<n;i++){
			cur1=cur1.next;
		}
		while(cur1.next!=null){
			cur1=cur1.next;
			cur2=cur2.next;
		}
		cur2.next=cur2.next.next;
		return dummy.next;       
    }
	public static void main(String[] args) {
		RemoveNthNodeFromEndofList a= new RemoveNthNodeFromEndofList();
		ListNode root=ListNode.generateListNode("1,2,3,4,5");
		System.out.println(a.removeNthFromEnd(root, 2));
	}

}
