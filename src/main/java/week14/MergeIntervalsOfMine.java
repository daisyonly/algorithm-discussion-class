package week14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import leetcode_others.Interval;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervalsOfMine {
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
						if (a.start == b.start) {
		                    return a.end - b.end;
		                }
				        return a.start - b.start;
					} 		
    	});
    	for(Interval i:intervals){
    		que.add(i);
    	}
    	while(!que.isEmpty()){
    		Interval peek = que.poll();
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
	
	public List<Interval> merge2(List<Interval> intervals) {
		  Collections.sort(intervals, new Comparator<Interval>() {
		    public int compare(Interval a, Interval b) {
		    	if (a.start == b.start) {
                    return a.end - b.end;
                }
		        return a.start - b.start;
		    }
		  });
		  List<Interval> result = new ArrayList<Interval>();
		  for (int i = 0; i < intervals.size(); i++) {
		    Interval curr = intervals.get(i);
		    while (i < intervals.size() - 1 && curr.end >= intervals.get(i + 1).start) {
		      curr.end = Math.max(curr.end, intervals.get(i + 1).end);
		      i++;
		    }
		    result.add(curr);
		  }
		  return result;
	}
	
	 public List<Interval> merge3(List<Interval> intervals) {
	        List<Interval> result = new ArrayList<Interval>();
	        Comparator<Interval> comparator = new Comparator<Interval>() {
	            @Override
	            public int compare(Interval o1, Interval o2) {
	                if (o1.start == o2.start) {
	                    return o1.end - o2.end;
	                }
	                return o1.start - o2.start;
	            }
	        };
	        Collections.sort(intervals, comparator);
	        for (Interval interval : intervals) {
	            int last = result.size();
	            if (last == 0 || result.get(last - 1).end < interval.start) {
	                Interval newInterval = new Interval(interval.start, interval.end);
	                result.add(newInterval);
	            } else {
	                result.get(last - 1).end = Math.max(interval.end, result.get(last - 1).end);
	            }
	        }
	        return result;
	    }
	
	public static void main(String[] args){
		List<Interval> ans = new LinkedList<Interval>();
		ans.add(new Interval(1,4));
		ans.add(new Interval(2,5));
		MergeIntervalsOfMine aa = new MergeIntervalsOfMine();
		System.out.println(aa.merge(ans));
	}
}
