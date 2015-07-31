package minimum_spanning_tree;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

	private int n;
	private int vset[];	
	//边的信息结点；
	class Edge{
		int begin,end,val;   //边的起始顶点,边的终止顶点,边的权值；
	    Edge(int begin,int end,int val){
	    	this.begin=begin;
	    	this.end=end;
	    	this.val=val;
	    }                                   
	}
	private int Find(int x){
		if(vset[x] !=x) vset[x] = Find(vset[x]);
		return vset[x];
	}
	private boolean uni(int a,int b){
		a=Find(a);
		b=Find(b);
		if(a==b) return false;
		else{
			vset[a]=b;
			return true;
		}
	}

	//kruskal算法,复杂富mlog(m)；
	public int kruskal(Edge E[],int vexnum){       //vexnum为顶点数,edgenum为边数;
		this.n=vexnum;
		vset = new int[this.n];
		Arrays.sort(E,new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				if(o1.val<o2.val) return 1;
				else return -1;
			}			
		});
		int sum=0;
		for(int i=0;i<vexnum;i++)              //初始化辅助数组；
			vset[i]=i;
		int k=1;                       //表示当前构造最小生成树的第几条边，初值为1；
		int j=0;                       //表示E中边的下标，初值为1；
		while(k<vexnum && j<E.length){             //生成的边数小于n时循环；			
			if(uni(E[j].begin,E[j].end)){    //两顶点属于不同的集合，该边是最小生成树的边；
				sum+=E[j].val;
				k++;                 //生成边数增1；
			}
			j++;                        //扫描下一条边；
		}
		return sum;
	}
}