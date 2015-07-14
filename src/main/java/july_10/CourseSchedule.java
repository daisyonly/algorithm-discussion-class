package july_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import week3.ListNode;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] list = new List[numCourses]; 
		for(int i=0;i<numCourses;i++)
			list[i] = new ArrayList<Integer>();
		int[] visited = new int[numCourses];
		Arrays.fill(visited, 0);
		for(int i=0;i<prerequisites.length;++i){
			list[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for(int i=0;i<numCourses;++i){
			if(dfs(list,visited,i)==false) return false;
		}
		
		return true;
        
    }

	private int dfs(List<Integer>[] list, int[] visited, int index) {
		// TODO Auto-generated method stub
		if(visited[index]==1) return 1;
		visited[index]=1;
		for(int i=0;i<list[index].size();++i){
			if(dfs(list, visited, list[index].get(i))==1){
				return 1;
			}
		}
		visited[index]=2;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
