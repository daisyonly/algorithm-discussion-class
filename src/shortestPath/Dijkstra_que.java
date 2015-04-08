package shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra_que {
	class Node
	{
		int num,dis;
		Node(int num,int dis){
			this.num = num;
			this.dis = dis;
		}
	};

	class Edge{
		int to,val;
		Edge(int to, int val){
			this.to = to;
			this.val = val;
		}
		
	}

	public void dijkstra(int s,int n,ArrayList<Edge> graph[])
	{
		PriorityQueue<Node> q = new PriorityQueue<Node>(n+1,
				new Comparator<Node>() {
					public int compare(Node a, Node b) {
						if (a.dis < b.dis)
							return 1;
						else if(a.dis == b.dis)
							return 0;
						else 
							return -1;
					}
		});
		boolean[] flag = new boolean[n+1];
		int[] dis = new int[n+1];//存单源S到各个点的最短路径长度
		int i,j;
		Node point;
		for(i=1;i<=n;i++){
			dis[i]=Integer.MAX_VALUE;
			flag[i]=false;
		}
		dis[s]=0;
		point = new Node(s, 0);
		q.add(point);
		while(!q.isEmpty()){
	        while(!q.isEmpty()&&flag[q.peek().num]) q.poll();
	        if(q.isEmpty()) break;
			i=q.poll().num;
			flag[i]=true;
			for(j=0;j<graph[i].size();j++)
				if(dis[graph[i].get(j).to]>dis[i]+graph[i].get(j).val)
				{
					dis[graph[i].get(j).to]= dis[i]+graph[i].get(j).val;
					point = new Node(graph[i].get(j).to,dis[graph[i].get(j).to]);
					q.add(point);
				}
		}
	}
}
