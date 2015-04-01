package week11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {
	
    public int ladderLength(String start, String end, Set<String> dict) {
    	Map<String,Integer> map = new HashMap<String,Integer>();
    	Queue<String> queue = new LinkedList<String>();
    	queue.add(start);
    	map.put(start, 1);
    	int distance =0;
    	while(!queue.isEmpty()){
    		String cur = queue.poll();
    		int dis = map.get(cur);
    		if(getEditDistance(cur, end)==1){
    			return dis+1;
    		}
    		for(String aString :dict){
    			if(!map.containsKey(aString)&&getEditDistance(aString, cur)==1){
    				queue.add(aString);
    				map.put(aString,dis+1);
    			}
    		}
    	}
		return distance;
        
    }
    
    private int getEditDistance(String s1, String s2) {
		int[][] dis = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i <= s1.length(); i++){
			dis[i][0] = i;
		}
		for(int i=0; i <= s2.length(); i++){
			dis[0][i] = i;
		}
		for(int i = 1;i <= s1.length(); i++){
			for(int j = 1; j <= s2.length(); j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dis[i][j] = dis[i-1][j-1];
				}else{
					dis[i][j] = Math.min(Math.min(dis[i-1][j], dis[i][j-1]), dis[i-1][j-1])+1;
				}
			}
		} 	   	
    	return dis[s1.length()][s2.length()];		
	}
    private void mian() {
    	WordLadder a = new WordLadder();
    	String start = "hit";
    	String end = "cog";
    	/*
    	 * dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
    	 */

	}
}
