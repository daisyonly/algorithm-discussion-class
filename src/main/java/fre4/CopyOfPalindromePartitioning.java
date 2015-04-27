package fre4;

import java.util.ArrayList;
import java.util.List;

public class CopyOfPalindromePartitioning {	
	 List<List<String>> resultLst;
     ArrayList<String> currLst;
     boolean isP[][];
     public List<List<String>> partition(String s) {
         resultLst = new ArrayList<List<String>>();
         currLst = new ArrayList<String>();
         isP = new boolean[s.length()][s.length()];
         backTrack(s,0);
         return resultLst;
     }
     public void backTrack(String s, int l){
         if(currLst.size()>0 //the initial str could be palindrome
             && l>=s.length()){
                 List<String> r = new ArrayList<String>(currLst);
                 resultLst.add(r);
         }
         for(int i=l;i<s.length();i++){
             if(s.charAt(l) == s.charAt(i)&&(i-l<2||isP[l+1][i-1])){
            	 isP[l][i]= true;
                 if(l==i)
                     currLst.add(Character.toString(s.charAt(i)));
                 else
                     currLst.add(s.substring(l,i+1));
                 backTrack(s,i+1);
                 currLst.remove(currLst.size()-1);
             }
         }
     }
   
     public static void main(String[] args) {
    	 CopyOfPalindromePartitioning a = new CopyOfPalindromePartitioning();
    	 System.out.println(a.partition("aab"));
	}
}
