package hard;

import week3.ListNode;

public class ReverseNodesinkGroup {
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(k==1) return head;
    	ListNode dummy = new ListNode(-1);
    	dummy.next= head;
    	ListNode preNode = dummy;
    	ListNode curNode = head;
    	while(curNode!=null){
    		ListNode end = move(curNode,k-1);
    		if(end!=null) {
    			ListNode tmp = end.next;
    			reverse(preNode,curNode,k-1);
    			preNode = curNode;
    			curNode=tmp;
    			preNode.next=curNode;
    		}else{
    			curNode = null;
    		}
    	}
    	return dummy.next;
	        
    }

	private void reverse(ListNode preNode,ListNode curNode, int k) {
		// TODO Auto-generated method stub
		ListNode curtmp = curNode;
		ListNode nextNode = curtmp.next;
		ListNode tmpNode = curtmp.next.next;
		while(k--!=0){
			nextNode.next = curtmp;
			curtmp=nextNode;
			nextNode = tmpNode;
			if(k!=0) tmpNode = tmpNode.next;
		}
		preNode.next = curtmp;
	}

	private ListNode move(ListNode curNode, int k) {
		// TODO Auto-generated method stub
		ListNode tmp = curNode;
		while(tmp!=null && k--!=0){
			tmp=tmp.next;
		}
		return tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = ListNode.generateListNode("1,2");
		ReverseNodesinkGroup aGroup= new ReverseNodesinkGroup();
		System.out.println(aGroup.reverseKGroup(root, 2));

	}

}
