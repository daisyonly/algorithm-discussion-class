package shortestPath.bellman;

import java.util.Arrays;

public class Bellman {
	
	//单源最短路径,bellman_ford算法,邻接阵形式,复杂度O(n^3)
	//求出源s到所有点的最短路经,传入图的大小n和邻接阵mat
	//返回到各点最短距离min[]和路径pre[],pre[i]记录s到i路径上i的父结点,pre[s]=-1
	//可更改路权类型,路权可为负,若图包含负环则求解失败,返回0
	//优化:先删去负边使用dijkstra求出上界,加速迭代过程
	public boolean bellman_ford (int mat[][], int s, int min[], int pre[]){
		int n=mat.length;
		boolean flag[] = new boolean[n];
		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.fill(pre, -1);
		min[s]=0;
		for (int j=0;j<n;j++){
			int tar=-1;
			for (int i=0;i<n;i++){
				if (!flag[i]&&(tar==-1||min[i]<min[tar]))
					tar=i;
			}
			flag[tar]=true;
			for (int i=0;i<n;i++)
				if (!flag[i] && mat[tar][i]>=0 && min[tar]+mat[tar][i]<min[i]){
					min[i]=min[tar]+mat[tar][i];
					pre[i]=tar;
				}
		}
		boolean tag=true;
		int j;
		for (j=0;tag && j<=n;j++){
			tag=false;
			for (int i=0;i<n;i++){
				for (int k=0;k<n;k++){
					if (min[k]+mat[k][i]<min[i]){
						min[i]=min[k]+mat[k][i];
						pre[i]=k;
						tag=true;
					}
				}
			}
		}
		return j<=n;
	}
}
