package inter_prepare;

import java.util.Stack;

public class CopyOfLongestValidParentheses {
	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();
		int left =-1;
		int ans=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='(') st.push(i);
			else{
				if(st.isEmpty()){
					left=i;
				}else{
					st.pop();
					if(st.isEmpty()){
						ans = i-left>ans? i-left:ans;
					}else{
						ans = i-st.peek()>ans ? i-st.peek():ans;
					}					
				}
			}
		}
		return ans;	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOfLongestValidParentheses test = new CopyOfLongestValidParentheses();
		System.out.println(test.longestValidParentheses(")()())"));

	}

}
