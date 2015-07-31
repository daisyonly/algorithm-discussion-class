package shortestPath;

public class Dijkstra {
	//单源最短路径,dijkstra算法,邻接阵形式,复杂度O(n^2)
	//求出源s到所有点的最短路经,传入图的顶点数n,(有向)邻接矩阵mat
	//返回到各点最短距离min[]和路径pre[],pre[i]记录s到i路径上i的父结点,pre[s]=-1
	//可更改路权类型,但必须非负!
	public void dijkstra(int n,int mat[][],int s,int[] min,int[] pre){
		int i,j,k;
		int[] v = new int[mat[0].length];
		for (i=0;i<n;i++){
			min[i]=Integer.MAX_VALUE;
			v[i]=0;
			pre[i]=-1;
		}
		for (min[s]=0,j=0;j<n;j++){
			for (k=-1,i=0;i<n;i++)
				if (v[i]!=0 && (k == -1 || min[i] < min[k]))
					k=i;
			for (v[k]=1,i=0;i<n;i++)
				if (v[i]!=0 && min[k]+mat[k][i]<min[i])
					min[i]=min[k]+mat[pre[i]=k][i];
		}
	}
	public static void main(String[] args) {
		int a;
		System.out.println(a=8);
	}
}
