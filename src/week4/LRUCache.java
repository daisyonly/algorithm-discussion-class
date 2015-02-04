package week4;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node{
		Node next,before;
		int key,value;
		public Node(int key, int value){
			this.next =null;
			this.before =null;
			this.key = key;
			this.value = value;
		}
	}
	private  int capacity;
	private Map<Integer, Node> map;
	private Node head, end;
	
	public LRUCache(int capacity) {
       this.capacity = capacity;
       map = new HashMap<Integer, LRUCache.Node>();
       this.head = null;
       this.end = null;
    }
	private void change(Node node){
		if(node == end && end != head){
    		end = node.before;
    	} 
		if(node.before != null){
    		node.before.next= node.next;       	
        	if(node.next != null)
        		node.next.before = node.before;
        	node.next = head;
        	head.before = node;
        	node.before = null;
        	head = node;    		
    	}
	}
    
    public int get(int key) {
    	Node node = map.get(key);
    	if( node == null) return -1; 	
    	change(node);
		return node.value;       
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node == null){
        	node = new Node(key, value);
        	map.put(key, node);
        	if(capacity != 0)
            	capacity --;
            else{
            	map.remove(end.key);
            	end = end.before;
            }
        	if(head == null){
        		head = node;
        	}else{
        		head.before = node;
        		node.next = head;
        		head = node;
        	}
        	if(end == null){
        		end = node;
        	}
        }else{
        	node.value = value;
        	change(node);
        }   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)
		LRUCache lruCache = new LRUCache(2);
		lruCache.set(2,1);
		lruCache.set(1,1);
		lruCache.set(2,3);
		lruCache.set(4,1);
		int a = lruCache.get(1);
		int b =lruCache.get(2);
		System.out.println(a+ "  " +b);
		

	}

}
