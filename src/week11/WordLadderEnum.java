package week11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-ladder/
public class WordLadderEnum {
	
    public int ladderLength(String start, String end, Set<String> dict) {
    	Map<String,Integer> map = new HashMap<String,Integer>();
    	Queue<String> queue = new LinkedList<String>();
    	queue.add(start);
    	map.put(start, 1);
    	while(!queue.isEmpty()){
    		String cur = queue.poll();
    		int dis = map.get(cur);
    		char[] c = cur.toCharArray();
    		for(int i=0; i < c.length; i++){
    			char original = c[i];
    			for(char j = 'a'; j <= 'z'; j++){
    				if(j!=original){
    					c[i]=j;
    					String tmp = String.valueOf(c);
    					if(tmp.equals(end)){
    						return dis+1;
    					}
    					if(dict.contains(tmp)&&!map.containsKey(tmp)){
    						queue.add(tmp);
    						map.put(tmp, dis+1);
    					}
    				}
    			}
    			c[i] = original;
    		}
    	}
		return 0;       
    }
    
    private static void addAll(Set<String> dict, String[] aaa) {
		for(String s:aaa){
			dict.add(s);
		}
	}
    public static void main(String[] args) {
    	WordLadderEnum a = new WordLadderEnum();
    	String start = "hit";
    	String end = "hii";
    	Set<String> dict = new HashSet<String>();     	
    	String [] aaa = {"hot","dot","dog","lot","log"};
    	addAll(dict, aaa);
    	System.out.println(dict.contains("hot"));
    	int ans = a.ladderLength(start, end, dict);
    	System.out.println(ans);

	}
}
