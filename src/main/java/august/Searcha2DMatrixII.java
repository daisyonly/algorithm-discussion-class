package august;

public class Searcha2DMatrixII {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null) return false;
		int n= matrix.length,m=matrix[0].length;
		int x=0,y=m-1;
		while(x<n&&y>=0){
			if(matrix[x][y]==target) return true;
			if(matrix[x][y]<target){
				x=x+1;
			}else{
				y=y-1;
			}
		}		
		return false;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[][]={
		              {1,   4,  7, 11, 15},
		              {2,   5,  8, 12, 19},
		              {3,   6,  9, 16, 22},
		              {10, 13, 14, 17, 24},
		              {18, 21, 23, 26, 30}
		};
		Searcha2DMatrixII testIi=new Searcha2DMatrixII();
		System.out.println(testIi.searchMatrix(nums, 5));
		

	}

}
