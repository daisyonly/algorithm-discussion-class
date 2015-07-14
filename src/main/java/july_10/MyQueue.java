package july_10;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> st_daoxu;
	private Stack<Integer> st_zhengxu;
	
	public MyQueue(){
		st_daoxu = new Stack<Integer>();
		st_zhengxu = new Stack<Integer>();
	}
	
	// Push element x to the back of queue.
    public void push(int x) {
        st_daoxu.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(!st_zhengxu.empty()){
			st_zhengxu.pop();
		}
		else if(!st_daoxu.empty()){
			tranfer();
			st_zhengxu.pop();
		}else{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
    }

    // Get the front element.
    public int peek() {
		if(!st_zhengxu.empty()){
			return st_zhengxu.peek();
		}
		else if(!st_daoxu.empty()){
			tranfer();
			return st_zhengxu.peek();
		}else{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
    }
    private void tranfer(){
    	while(!st_daoxu.empty()){
			st_zhengxu.push(st_daoxu.pop());
		}	
    }

    // Return whether the queue is empty.
    public boolean empty() {
		return st_daoxu.empty()&&st_zhengxu.empty();     
    }

}
