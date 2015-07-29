package july_1;

import java.util.Arrays;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix==null||matrix.length==0) return 0;
		int dp[][]= new int[2][matrix[0].length];
		int index=1,ans=0;;
		for(int i=0;i<matrix[0].length;i++){
			dp[0][i]=matrix[0][i]-'0';
			ans=dp[0][i]>ans? dp[0][i]:ans;
		}
		for(int i=1;i<matrix.length;i++){
			dp[index][0]=matrix[i][0]-'0';
			ans=dp[index][0]>ans? dp[index][0]:ans;
			for(int j=1;j<matrix[i].length;j++){
				if(matrix[i][j]=='1'){
					dp[index][j]=Math.min(dp[1-index][j-1], Math.min(dp[1-index][j], dp[index][j-1]))+1;
				    //System.out.print(dp[index][j]+" ");
					ans=dp[index][j]>ans? dp[index][j]:ans;
				}else{
					dp[index][j]=0;
				}
			}
			//System.out.println();
			index=1-index;
			//Arrays.fill(dp[index], 0);
		}
		//System.out.println(ans);
		return ans*ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char nums[][]={
				{'1','0','1','1','0','1'},
				{'1','1','1','1','1','1'},
				{'0','1','1','0','1','1'},
				{'1','1','1','0','1','0'},
				{'0','1','1','1','1','1'},
				{'1','1','0','1','1','1'}
		};
		
		MaximalSquare a =new MaximalSquare();
		System.out.println(a.maximalSquare(nums));

	}

}
