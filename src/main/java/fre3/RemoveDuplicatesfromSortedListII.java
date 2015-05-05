package fre3;

import week3.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next=head;
		ListNode curNode=dummy.next,preNode=dummy;
		boolean flag=false,delete;
		while(curNode!=null){
			delete = flag;
			if(curNode.next!=null &&curNode.val==curNode.next.val){
				//System.out.println(curNode.val);
				delete= true;
				flag= true;
			}else{
				flag= false;
			}
			if(delete){
				preNode.next=curNode.next;
			}else{
				preNode=curNode;
			}
			curNode=curNode.next;
		}
		return dummy.next;
    }
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII a = new RemoveDuplicatesfromSortedListII();
		ListNode root = ListNode.generateListNode("1,1,2");
		System.out.println(a.deleteDuplicates(root));
	}

}
