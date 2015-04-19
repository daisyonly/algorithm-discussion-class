package leetcode_others;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertInterval {
   public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	   List<Interval> ans = new LinkedList<Interval>();
	   Interval tmp = new Interval(newInterval.start,newInterval.end);
	   boolean flag= true;
	   for(Interval a:intervals){
		   if(a.end<newInterval.start){
			   ans.add(a);
		   }else if(a.start > newInterval.end){
			   if(flag){
				   ans.add(tmp);
				   flag=false;
			   }
			   ans.add(a);
		   }else{
			   tmp.start = tmp.start<a.start? tmp.start:a.start;
			   tmp.end = tmp.end>a.end? tmp.end:a.end;
		   }
	   }
	   if(flag) ans.add(tmp);
	   return ans;      
   }

}
