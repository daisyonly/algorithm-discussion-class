package july_10;

import week3.ListNode;

public class PalindromeLinkedList {
	
	public boolean isPalindrome(ListNode head) {
		if(head == null)return true;
		ListNode reverHead = copyList(head);
		ListNode cur = head;
		ListNode recur = reverHead;
		
		//System.out.println(cur);
		//System.out.println(recur);
		
		int count =0;
		while(cur!=null){
			count++;
			cur=cur.next;
		}
		//System.out.println(count);
		cur=head;
		int i=count/2;
		while(i-->0){
			if(cur.val != recur.val) return false;
			cur=cur.next;
			recur=recur.next;
		}
		return true;
        
    }
	private ListNode copyList(ListNode head) {
		ListNode reHead = reverseLinklist(head);
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		ListNode old = reHead;
		while(old!=null){
			cur.next=new ListNode(old.val);
			old=old.next;
			cur=cur.next;
		}
		head = reverseLinklist(reHead);
		return dummy.next;
		
	}

	private ListNode reverseLinklist(ListNode head) {
		// TODO Auto-generated method stub
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head.next;		
		while(cur!=null){
			cur.next=pre;
			pre=cur;
			cur=next;
			if(cur!=null)next=cur.next;
		}
		return pre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = ListNode.generateListNode("1,1,2,1");
		PalindromeLinkedList aLinkedList= new PalindromeLinkedList();
		System.out.println(aLinkedList.isPalindrome(root));

	}

}
