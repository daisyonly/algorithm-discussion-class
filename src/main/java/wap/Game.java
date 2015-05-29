package wap;

import java.util.Scanner;

public class Game {
	public static final int NoC = -2;
	public static long map[][];
	public static long dp[][][];
	
	public static void main(String[] args) {
		int n,m,num;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		map = new long[n+1][m+1];
		dp = new long[n+1][m+1][2];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				 map[i][j]=cin.nextLong();
				 dp[i][j][0] = NoC;
				 dp[i][j][1] = NoC;
			}
		}
		dfs(1,1,0);
		/*
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				for(int k=0;k<2;k++){
					//dp[i][j][k]
				}
				dp[i][j][0]=Math.min(dp[i][j-1][0], dp[i][j-1][1]);
				dp[i][j][0]=Math.min(dp[i][j][0], dp[i+1][j][0]);
				dp[i][j][0] = dp[i][j][0]+ map[i][j];
				
				dp[i][j][1]=Math.min(dp[i][j-1][0], dp[i][j-1][1]);
				dp[i][j][1]=Math.min(dp[i][j][0], dp[i+1][j][0]);
			}
		}
		*/
	}

	private static long dfs(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(dp[i][j][k] != NoC) return dp[i][j][k];
		if(map[i][j]==-1){
			dp[i][j][k] = -1;
			return dp[i][j][k];
		}
		dp[i][j][k] = Integer.MAX_VALUE; 
		long num = dfs(i,j-1,k);
		if(num != -1) dp[i][j][k]= Math.min(num, dp[i][j][k]);
		num = dfs(i,j-1,k);
		dp[i][j][k] = Math.min(num, dp[i][j][k]);
		if(k==0){		
			dp[i][j][k] = Math.min(dp[i][j][k], dfs(i+1,j,k));	
		}else{
			dp[i][j][k]=Math.min(dp[i][j][k], dfs(i-1,j,k));
		}
		return dp[i][j][k]+map[i][j];	
	}
}
