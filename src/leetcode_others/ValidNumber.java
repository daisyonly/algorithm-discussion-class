package leetcode_others;

//https://leetcode.com/problems/valid-number/
public class ValidNumber {
	
	public boolean isNumber(String s) {
	    s = s.trim();
	    boolean pointSeen = false;//标志当前字符串是否含有小数点‘.’
	    boolean eSeen = false;//标志是否已经出现过e；
	    boolean numberSeen = false;//标志是否含有数字
	    boolean numberAfterE = true;//当没有e或者e后面有数字时为true
	    for(int i=0; i<s.length(); i++) {
	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	            numberSeen = true;
	            numberAfterE = true;
	        } else if(s.charAt(i) == '.') {
	            if(eSeen || pointSeen) {
	                return false;
	            }
	            pointSeen = true;
	        } else if(s.charAt(i) == 'e') {
	            if(eSeen || !numberSeen) {
	                return false;
	            }
	            numberAfterE = false;
	            eSeen = true;
	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	            if(i != 0 && s.charAt(i-1) != 'e') {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	    return numberSeen && numberAfterE;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
