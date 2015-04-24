package fre4;

import week3.ListNode;

public class SwapNodesinPairs {
	
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		while(cur!=null&&cur.next!=null&&cur.next.next!=null){
			ListNode one = cur.next;
			ListNode two = one.next;
			ListNode tmp = two.next;
			two.next = one;
			cur.next = two;
			one.next = tmp;
			cur = one;
		}
		return dummy.next;  
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = ListNode.generateListNode("1,2,3,4");
		SwapNodesinPairs a = new SwapNodesinPairs();
		System.out.println(a.swapPairs(root));

	}

}
