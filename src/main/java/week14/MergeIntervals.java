package week14;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import leetcode_others.Interval;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new LinkedList<Interval>();
		if(intervals==null || intervals.size()==0) return ans;
		/*
		 * int compare(Object o1, Object o2) 返回一个基本类型的整型，默认升序
		 * 返回-1 表示o1 小于o2;
		 * 返回0 表示o1和o2相等;
		 * 返回1 表示o1大于o2。 
		 */
    	PriorityQueue<Interval> que = new PriorityQueue<Interval>(intervals.size(),
    			new Comparator<Interval>(){
					@Override
					public int compare(Interval a, Interval b) {
						if (a.start > b.start)
						    return 1;
					    else if(a.start == b.start)
						    return 0;
					    else 
						    return -1;
					} 		
    	});
    	for(Interval i:intervals){
    		que.add(i);
    	}
    	while(!que.isEmpty()){
    		Interval peek = que.poll();
    		System.out.println(peek);
    		if(que.isEmpty()){
    			ans.add(peek);
    		}else{
    			Interval nextPeek = que.peek();
    			if(peek.end>=nextPeek.start){
    				que.poll();
    				que.add(new Interval(peek.start, peek.end>nextPeek.end ? peek.end:nextPeek.end));
    			}else{
    				ans.add(peek);
    			}
    		}
    	}  	
    	return ans;      
    }
	public static void main(String[] args){
		List<Interval> ans = new LinkedList<Interval>();
		ans.add(new Interval(1,4));
		ans.add(new Interval(2,5));
		MergeIntervals aa = new MergeIntervals();
		System.out.println(aa.merge(ans));
	}
}
