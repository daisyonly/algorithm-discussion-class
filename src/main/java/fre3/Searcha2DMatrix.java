package fre3;

//https://leetcode.com/problems/search-a-2d-matrix/
public class Searcha2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix==null||matrix.length==0) return false;
		 int n = matrix.length;
		 int m = matrix[0].length;
		 int left = 0,right=n-1;
		  while(left<=right){
			  int mid = (left+right)>>1;
		      if(matrix[mid][0]==target) return true;
		      if(matrix[mid][0] > target){
		    	  right= mid-1;
		      }else if(matrix[mid][0]<target){
		    	  left = mid+1;
		      }
		  }
		  int targerow = right<0? left:right;
		  int colleft =0 ,colright=m-1;
		  //System.out.println(targerow);
    	  while(colleft<=colright){
    		  int colmid = (colleft+colright)>>1;
    	      if(matrix[targerow][colmid]==target) return true;
    	      if(matrix[targerow][colmid]>target)  colright = colmid-1;
    	      else colleft = colmid+1;
    	  }
		return false;	        
	 }
	 public static void main(String[] args) {
		int nums[][]={{1,3,10,11},{7,11,16,20},{23,30,34,50}};
		 //int nums[][]={{1}};
		Searcha2DMatrix a = new Searcha2DMatrix();
		System.out.println(a.searchMatrix(nums, 10));
		
	}

}
