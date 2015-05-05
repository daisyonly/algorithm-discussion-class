package fre3;

import week3.ListNode;

public class PartitionList {
	
	public ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(-1);
		dummy.next= head;
		ListNode small = dummy,curNode=head;
		ListNode preNode=dummy;
		while(curNode!=null){
			if(curNode.val<x){				
				if(small.next.val!=curNode.val){					
					ListNode tmp = small.next;
					small.next=curNode;
					preNode.next=curNode.next;
					curNode.next = tmp;
				}else{
					preNode=curNode;
				}
				small=small.next;
			}else{
				preNode=curNode;
			}
			curNode=preNode.next;
		}
		return dummy.next;     
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root= ListNode.generateListNode("1,4,3,2,5,2");
		PartitionList a= new PartitionList();
		System.out.println(a.partition(root, 3));

	}

}
