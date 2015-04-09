package leetcode_others;
//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroesOfMine {
	//用matrix[0][0]标记第一行是否有0（因为其身兼两职啊。。。所以分开处理），否则第一行会出错
	//用flag标记第一列是否有0；
    //[[1,1,1],[0,1,2]]例子
	public void setZeroes(int[][] matrix) {
		int raws = matrix.length;
		int cols = matrix[0].length;
		boolean flag = false;
		for(int i=0;i<raws;i++){
			if(matrix[i][0]==0) flag= true;
			for(int j=1;j<cols;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=matrix[0][j]=0;
				}
			}
		}
		for(int i=raws-1; i>=0; i--){
			for(int j=cols-1; j>=1; j--){
				if(matrix[i][0]==0||matrix[0][j]==0)
					matrix[i][j]=0;
			}
			if(flag) matrix[i][0] = 0;
		}
	}
}
