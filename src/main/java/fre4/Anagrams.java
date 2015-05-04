package fre4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
    	Map<String, Integer> count = new HashMap<String, Integer>();
    	Map<String, String> map = new HashMap<String, String>();
    	List<String> ans = new LinkedList<String>();
    	for(String str:strs){
    		char tmp[] = str.toCharArray();
    		Arrays.sort(tmp);
    		String kString =new String(tmp);
    		if(!count.containsKey(kString)){
    			count.put(kString, 1);
    		}else{
    			count.put(kString, count.get(kString)+1);
    		}
    		map.put(str, kString);
    	}
    	for(String str:strs){
    		if(count.get(map.get(str))>1){
    			ans.add(str);
    		}
    	}
		return ans;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams a = new Anagrams();
		String haha[] = {"ate","ba","eat"};
		System.out.println(a.anagrams(haha));

	}

}
