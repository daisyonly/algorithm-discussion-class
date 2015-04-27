package fre4;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {	
	 
     public List<List<String>> partition(String s) {
    	 List<List<String>> result = new LinkedList<List<String>>();
    	 List<String> tmp = new LinkedList<String>();
    	 boolean isP[][] = new boolean[s.length()][s.length()];
    	 char c[]=s.toCharArray();
    	 findPalindrome(isP,result,tmp,c,0);
         return result;
     }
     
   
     private void findPalindrome(boolean isP[][],List<List<String>> result, List<String> tmp,
			char[] c, int start) {
		// TODO Auto-generated method stub
    	 if(start == c.length){
    		 result.add(new LinkedList<String>(tmp));
    	 }
    	 for(int i=start;i<c.length;i++){
    		 if(c[i]==c[start] &&(i-start<2||isP[start+1][i-1])){
    			 isP[start][i] = true;
    			 tmp.add(new String(c,start,i-start+1));
    			 findPalindrome(isP, result, tmp, c, i+1);
    			 tmp.remove(tmp.size()-1);
    		 }   		
    	 }		
	}


	public static void main(String[] args) {
    	PalindromePartitioning a = new PalindromePartitioning();
    	System.out.println(a.partition("aab"));
		char c[]={'a','b','c','d'};
		String string = new String(c, 0, 1);
		System.out.print(string);
	}
}
