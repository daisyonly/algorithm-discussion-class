package week12;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode_others.Interval;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
	
   public int lengthOfLongestSubstring(String s, List<Interval> intervals) {
	   /*
		 * int compare(Object o1, Object o2) 返回一个基本类型的整型，默认升序
		 * 返回-1 表示o1 小于o2;
		 * 返回0 表示o1和o2相等;
		 * 返回1 表示o1大于o2。 
		 */
	   Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start == o2.start){
					return o1.end-o2.end;
				}
				return o1.start-o2.start;
			}	
		});
	return 0;
   }

}
