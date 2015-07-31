package minimum_spanning_tree;

public class Prim {
	//无向图最小生成树,prim算法,邻接阵形式,复杂度O(n^2)
	//返回最小生成树的长度,传入图的大小n和邻接阵mat,不相邻点边权inf
	//可更改边权的类型,pre[]返回树的构造,用父结点表示,根节点(第一个)pre值为-1
	//必须保证图的连通的!
	public double prim(int n,double mat[][],int pre[]){
		double min[]= new double[n];
		double ret=0;
		boolean flag[]=new boolean[n];
		for (int i=0;i<n;i++){
			min[i]=Double.MAX_VALUE;
			pre[i]=-1;
		}
		min[0]=0;
		for (int j=0;j<n;j++){
			int k=-1;
			for (int i=0;i<n;i++)
				if (!flag[i]&&(k==-1||min[i]<min[k]))
					k=i;
			flag[k]=true;
			ret=ret+min[k];
			for (int i=0;i<n;i++)
				if (!flag[i]&&mat[k][i]<min[i]){
					min[i]=mat[k][i];
					pre[i]=k;
				}
		}
		return ret;
	}

}
