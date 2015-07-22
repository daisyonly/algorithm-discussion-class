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
			if(dfs(list,visited,i)==1) return false;
		}
		
		return true;
        
    }
    
	private int dfs(List<Integer>[] list, int[] visited, int index) {
		// TODO Auto-generated method stub
		if(visited[index]!=0) return visited[index];
		
		visited[index]=1;
		for(int i=0;i<list[index].size();++i){
			if(dfs(list, visited, list[index].get(i))==1){
				return 1;
			}
		}
		visited[index]=2;
		return 2;
	}
	
	int count;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] ans = new int[numCourses];
    	List<Integer>[] list = new List[numCourses]; 
		for(int i=0;i<numCourses;i++)
			list[i] = new ArrayList<Integer>();
		int[] visited = new int[numCourses];
		Arrays.fill(visited, 0);
		for(int i=0;i<prerequisites.length;++i){
			list[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		count=0;
		for(int i=0;i<numCourses;++i){
			int tmp=dfs(list,visited,i,ans);
			System.out.println(tmp);
			if(tmp==1) {
				System.out.println(tmp);
				return new int[numCourses];
			}
		}
		System.out.println("hehe");
    	return ans;     
    }

	private int dfs(List<Integer>[] list, int[] visited, int index, int[] ans) {
		// TODO Auto-generated method stub
			if(visited[index]!=0) return visited[index];
		
			visited[index]=1;
			for(int i=0;i<list[index].size();++i){
				if(dfs(list, visited, list[index].get(i),ans)==1){
					return 1;
				}
			}
			visited[index]=2;
			ans[count++]=index;
			return 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule a = new CourseSchedule();
		int[][] prerequisites={{0,1},{1,0}};
		int ans[] = a.findOrder(2, prerequisites);
		for(int i=0;i<ans.length;i++){
		   System.out.print(ans[i]+" ");
		}

	}

}
