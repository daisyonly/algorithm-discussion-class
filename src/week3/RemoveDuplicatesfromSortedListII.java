package week3;

public class RemoveDuplicatesfromSortedListII {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode dummy =  new ListNode(-1);
		dummy.next = head;
		ListNode curNode = head;
		ListNode preNode = dummy;
		boolean flag = false;
		while(curNode!= null){	
			boolean delete = flag;
			if(curNode.next!=null){
				if(curNode.val == curNode.next.val){
					 delete =true;
					 flag = true;
				}				  
				else{
					flag = false;
				}
			}
			if(delete){
				preNode.next = curNode.next;
			}
			else{
				preNode = curNode;
			}
			curNode = curNode.next;
		}				
		return dummy.next;       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = ListNode.generateListNode("1 1 1 2 3");
		System.out.println(RemoveDuplicatesfromSortedListII.deleteDuplicates(node));

	}

}
