package inter_prepare;

import java.util.Scanner;
public class Exam1 {
	public static final long NoC = -2;
	public static long map[][];
	public static long dp[][][];
	public static int n,m;
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		map = new long[n+2][m+2];
		dp = new long[n+2][m+2][2];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				 map[i][j]=cin.nextLong();
				 dp[i][j][0] = NoC;
				 dp[i][j][1] = NoC;
			}
		}
		cin.close();
		long ans =-1;
		for(int i=1;i<=n;i++){
			long tmp = dfs(i,m, 0);
			ans = Math.max(ans, tmp);
			tmp = dfs(i,m, 1);
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}

	private static long dfs(int i, int j, int k) {
		if(dp[i][j][k] != NoC) return dp[i][j][k];
		if(map[i][j] == -1){
			dp[i][j][k] = -1;
			return dp[i][j][k];
		}
		long num = dfs(i,j-1,0);
		if(num != -1) dp[i][j][k] = Math.max(num, dp[i][j][k]);
		num = dfs(i,j-1,1);
		if(num != -1) dp[i][j][k] = Math.max(num, dp[i][j][k]);
		if(k==0){
			if(i < n){
				num = dfs(i+1,j,k);
				if(num != -1) dp[i][j][k] = Math.max(dp[i][j][k],num);	
			}else{
				if(dfs(1, j, k)!=-1) dp[i][j][k] = Math.max(dp[i][j][k],0);	
			}			
		}else{
			if(i>1){
				num = dfs(i-1,j,k);
				if(num != -1) dp[i][j][k] = Math.max(dp[i][j][k], num);
			}else{
				if(dfs(n, j, k)!=-1)dp[i][j][k] = Math.max(dp[i][j][k], 0);	
			}
		}
		if(dp[i][j][k]==-1) return -1;
		dp[i][j][k] += map[i][j];
		return dp[i][j][k];	
	}
}
