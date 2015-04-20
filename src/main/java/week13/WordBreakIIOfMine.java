package week13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/word-break-ii/
public class WordBreakIIOfMine {
	public List<String> wordBreak(String s, Set<String> dict){
		if(!isPossible(s,dict)) return new LinkedList<String>();
		Map<Integer, LinkedList<String>> dpMap = new HashMap<Integer, LinkedList<String>>();
		LinkedList<String> base = new LinkedList<String>();
		base.add("");
		dpMap.put(0, base);
		for(int i=0;i<s.length();i++){
			LinkedList<String> tmp = new LinkedList<String>();
			for(int j=0; j<=i; j++){
				if(dict.contains(s.substring(j, i+1)) && dpMap.get(j).size()!=0){
					for(String string : dpMap.get(j)){
						tmp.add(string + (string.length() == 0? "":" ")	+ s.substring(j, i+1));
					}
				}
			}
			dpMap.put(i+1, tmp);
		}
		return dpMap.get(s.length());		
	}

	private boolean isPossible(String s, Set<String> dict) {
		boolean isSub[] = new boolean[s.length()+1];
		isSub[0] = true;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				isSub[i+1] = isSub[j] && dict.contains(s.substring(j,i+1));
				if(isSub[i+1]) break;
			}
		}
		return isSub[s.length()];
	}
	private static void add(String s[],Set<String> dict) {
		// TODO Auto-generated method stub
		for(int i=0;i<s.length;i++){
			dict.add(s[i]);
		}
	}
	public static void main(String[] args) {
		//'baaaaaaaa...aaaa', ['a', 'aa', 'aaa', ..., 'aaa...aa']
		WordBreakIIOfMine a = new WordBreakIIOfMine();
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
