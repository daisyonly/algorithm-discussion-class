package minimum_spanning_tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CopyOfKruskal {
    class Edge{
    	int begin,end,val;
    	Edge(int behin,int end,int val){
    		this.begin = behin;
    		this.end = end;
    		this.val = val;
    	}
    }
	
	public int kruskal(int n,List<Edge> edges, Edge ans[]){
		int vset[]=new int[n];
		int sum=0;
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				if(o1.val<o2.val)
				   return 1;
				else return -1;
			}
		});
		for(int i=0;i<n;i++) vset[i]=i;
		int count=0,index=0;
		while(count<n&&index<edges.size()){
			Edge curEdge=edges.get(index++);
			if(union(curEdge.begin,curEdge.end,vset)){
				sum=sum+curEdge.val;
				ans[count++]=curEdge;
			}
		}		
		return sum;
	}

	private boolean union(int a, int b, int[] vset) {
		a=find(a,vset);
		b=find(b, vset);
		if(a!=b){
			vset[b]=a;
			return true;
		}
		return false;
	}

	private int find(int x, int[] vset) {
		if(vset[x]!=x){
			vset[x]=find(vset[x], vset);
		}
		return vset[x];
	}
}