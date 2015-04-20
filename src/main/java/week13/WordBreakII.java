package week13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break-ii/
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
	    if(!isPossible(s, dict)) return new LinkedList<String>();
	    // index: subString(0,index) -> result List<String>
	    HashMap<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
	    List<String> base = new LinkedList<String>();
	    base.add("");
	    dp.put(0, base);
	    for(int i=0; i<s.length(); i++) {
	        List<String> cur = new LinkedList<String>();
	        dp.put(i+1, cur);
	        for(int j=0; j<=i; j++) {
	            if( dict.contains(s.substring(j,i+1)) ) {    // [0...j-1] && [j...i]; condition: dp[j].size()!=0 simplified
	                for( String str : dp.get(j) ) {
	                    dp.get(i+1).add(str+ (str.length()==0? "":" ") + s.substring(j, i+1));
	                }
	            }
	        }
	    }
	    return dp.get(s.length());
	}
	 
	public boolean isPossible(String s, Set<String> dict) { // exactly same code of with WB I
	    int len = s.length();
	    boolean[] isSub = new boolean[len+1];
	    isSub[0] = true;    // empty str is substring
	    for(int i=0; i<len; i++) {
	        for(int j=0; j<=i; j++) {
	            isSub[i+1] = isSub[j] && dict.contains(s.substring(j,i+1));
	            if( isSub[i+1] ) {
	                break;  // break from inner for loop
	            }
	        }
	    }
	    return isSub[len];  // return last member
	     
	}
	private static void add(String s[],Set<String> dict) {
		// TODO Auto-generated method stub
		for(int i=0;i<s.length;i++){
			dict.add(s[i]);
		}
	}
	public static void main(String[] args) {
		//'baaaaaaaa...aaaa', ['a', 'aa', 'aaa', ..., 'aaa...aa']
		WordBreakII a = new WordBreakII();
		String string = "aaaaaaaaaaaa";
		String s[] = {"a", "aa", "aaa", "aaaa", "aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaaa"};
		Set<String> dict = new HashSet<>();
		add(s,dict);
		List<String> ans = a.wordBreak(string, dict);
		int i=0;
		for(String aString :ans){
			System.out.println(i+":"+aString);
			i++;
		}
	}

}
