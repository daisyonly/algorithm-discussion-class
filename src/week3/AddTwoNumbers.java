package week3;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = null;
		ListNode last = null;
		ListNode node = null;
		int flag =0;
		while(l1 != null && l2 != null){
			int sum = l1.val+l2.val+ flag;
			flag = sum/10;
			if(ans != null){
				node = new ListNode(sum%10);
				last.next=node;
				last = node;
			}else{
				ans = new ListNode(sum%10);
				last=ans;				
			}
			l1= l1.next;
			l2=l2.next;
		}
		while(l1 != null){
			int sum = l1.val+ flag;
			flag = sum/10;
			node = new ListNode(sum%10);
			last.next=node;
			last = node;
			l1= l1.next;
		}
		while(l2 != null){
			int sum = l2.val+ flag;
			flag = sum/10;
			node = new ListNode(sum%10);
			last.next=node;
			last = node;
			l2= l2.next;
		}
		if(l1 == null && l2 == null && flag!=0){
			node = new ListNode(flag);
			last.next=node;
		}				
		return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
