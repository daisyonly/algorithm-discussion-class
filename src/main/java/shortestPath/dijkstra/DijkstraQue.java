package shortestPath.dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class DijkstraQue {
	
	class Node{
		int index;
		int dis;
		Node(int index,int dis){
			this.index=index;
			this.dis=dis;
		}
	}
	class Edge{
		int to;
		int val;
		Edge(int to,int val){
			this.to=to;
			this.val=val;
		}
	}
	
	public int[] dijkstra(List<Edge> graph[],int s,int pre[]){
		int n=graph.length;
		int dis[]=new int[n];
		boolean flag[]=new boolean[n];
		PriorityQueue<Node> que= new PriorityQueue<Node>(n, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if (a.dis < b.dis)
					return 1;
				else if(a.dis == b.dis)
					return 0;
				else 
					return -1;
			}
		});
		que.offer(new Node(s, 0));
		dis[s]=0;
		while(!que.isEmpty()){
			Node peekNode=que.poll();
			if(flag[peekNode.index]) continue;
			int index=peekNode.index;
			flag[index]=true;
			for(int i=0;i<graph[index].size();i++){
				if(dis[graph[index].get(i).to]>dis[index]+graph[index].get(i).val){
					dis[graph[index].get(i).to]=dis[index]+graph[index].get(i).val;
					que.offer(new Node(graph[index].get(i).to, dis[graph[index].get(i).to]));
					pre[graph[index].get(i).to]=index;
				}
			}
		}		
		return dis;
	}

}
