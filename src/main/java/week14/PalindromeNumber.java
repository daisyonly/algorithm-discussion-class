package week14;

//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if(x<0) return false;
    	int gewei,gaowei;
    	int count =1;
    	while(x/count>=10){
    		count = count*10;
    	}
    	while(x > 0){
    		gewei = x%10;
    		gaowei = x/count;
    		if(gaowei!= gewei) return false;
    		x=x-x/count*count;
    		x=x/10;
    		count= count/100; 		
    	}
		return true;       
    }
    public static void main(String[] args) {
    	PalindromeNumber a = new PalindromeNumber();
    	System.out.println(a.isPalindrome(121));
	}

}
