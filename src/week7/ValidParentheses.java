package week7;

import java.util.Stack;


//https://oj.leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> str = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c==')'){
				if(!str.isEmpty()&& str.peek().equals('(')){
					str.pop();
				}else {
					return false;
				}				
			}else if(c==']'){
				if(!str.isEmpty()&&str.peek().equals('[')){
					str.pop();
				}else {
					return false;
				}				
			}else if(c=='}'){
				if(!str.isEmpty()&&str.peek().equals('{')){
					str.pop();
				}else {
					return false;
				}				
			}else{
				str.push(c);
			}
		}
		return str.isEmpty()? true:false;	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses aParentheses = new ValidParentheses();
		System.out.println(aParentheses.isValid("]"));

	}

}
