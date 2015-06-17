package inter_prepare;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int ans =0;
		int start=0;
		for(int i=0;i<s.length();i++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), i);
			}else{
				int index = map.get(s.charAt(i));
				System.out.println(i+" "+start);
				ans = i-start > ans? i-start:ans;
				for(int j=start;j<=index;j++){
					map.remove(s.charAt(j));
				}
				map.put(s.charAt(i), i);
				start = index+1;
			}
		}
		ans = s.length()-start>ans? s.length()-start:ans;
		return ans;   
    }
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters aCharacters = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(aCharacters.lengthOfLongestSubstring("abcd"));
		
	}

}
