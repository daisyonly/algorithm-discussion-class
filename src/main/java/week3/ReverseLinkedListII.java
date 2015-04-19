package week3;


public class ReverseLinkedListII {
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode curNode = head;
		ListNode mLast = null;
		int index=1;
		while(index < m){
			if(index == m-1) 
				mLast= curNode;
			curNode= curNode.next;
			index++;
		}
		ListNode mNode = curNode;
		ListNode nNode = null;
		ListNode nextNode = mNode;
		curNode= curNode.next;
		index++;
		//此时m+1==index
		while(index <= n){
			ListNode tmp = curNode;
			if(index==n) nNode = curNode;
			curNode = curNode.next;
			index++;
			tmp.next= nextNode;
			nextNode = tmp;			
		}
		mNode.next = curNode;
		if( mLast!=null) {
			mLast.next = nNode;	
			return head;
		}else{
			return nNode;
		}       
    }
	
	public ListNode reverseBetween3(ListNode head, int m, int n) {
		ListNode dummy =  new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy; 
		for (int i = 0; i < m-1; ++i)
			prev = prev.next;
		ListNode head2 = prev;//指向m的前一个元素
		prev = head2.next; //指向m
		ListNode cur = prev.next;//指向m的下一个节点
		for (int i = m; i < n; ++i) {
			prev.next = cur.next;
			cur.next = head2.next;
			head2.next = cur; // 头插法
			cur = prev.next;
		}
		return dummy.next;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode tmp = new ListNode(1);
		ListNode tmp1 = new ListNode(2);
		ListNode tmp2 = new ListNode(3);
		tmp.next= tmp1;
		tmp1.next =tmp2;
		ListNode node = ListNode.generateListNode("3 5");
		ReverseLinkedListII haha = new ReverseLinkedListII();
		ListNode em = haha.reverseBetween(node, 1, 2);
		System.out.println(em);
	}

}
