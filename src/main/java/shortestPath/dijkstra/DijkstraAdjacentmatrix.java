package shortestPath.dijkstra;

import java.util.Arrays;


public class DijkstraAdjacentmatrix {
	
	public int[] dijkstra(int s,int map[][], int pre[]){
		int n=map.length;
		int ans[] = new int[n];
		boolean flag[]=new boolean[n];
		Arrays.fill(ans, Integer.MAX_VALUE); 
		Arrays.fill(pre, -1);
		ans[s]=0;
		for(int j=0;j<n;j++){
			int tar=-1;
			for(int i=0;i<n;i++){
				if(!flag[i]&&(tar==-1||ans[i]<ans[tar]))
					tar=i;
			}
			flag[tar]=true;
			for(int i=0;i<n;i++){
				if(!flag[i]&&(ans[i]>map[tar][i]+ans[tar])){
					ans[i]=map[tar][i]+ans[tar];
					pre[i]=tar;
				}
			}
		}	
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijkstraAdjacentmatrix testAdjacentmatrix = new DijkstraAdjacentmatrix();
		int map[][]={
				{0,2,3},
				{2,0,6},
				{3,6,0}
		};
		int pre[]=new int[3];
		int ans[]= testAdjacentmatrix.dijkstra(0, map, pre);
		System.out.println(Arrays.toString(ans));
		System.out.println(Arrays.toString(pre));

	}

}
