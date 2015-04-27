package week14;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ans = new LinkedList<Integer>();
    	int n = matrix.length;
    	if(n==0) return ans;
    	int m = matrix[0].length;
    	boolean flag[][] = new boolean[n][m]; 
    	int dx[] = {0,1,0,-1};
    	int dy[] = {1,0,-1,0};
    	int count = 0;
    	int curX =0,curY=0;
    	int newX,newY;
    	ans.add(matrix[curX][curY]);
    	flag[curX][curY]= true;
    	count++;
    	while(count < m*n){
    		for(int i=0;i<4;i++){
    			while(true){
    				newX = curX+dx[i];
        			newY = curY+dy[i];
        			if(check(newX, newY, n, m)&&!flag[newX][newY]){
        				curX = newX;
        				curY = newY;
        				ans.add(matrix[curX][curY]);
        		    	flag[curX][curY]= true;
        		    	count++;
        			}else{
        				break;
        			}
    			}
    			
    		}
    	}
		return ans;    
    }
    private boolean check(int i,int j,int n,int m) {
		if(i>=0&&j>=0 && i < n && j<m) return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		SpiralMatrix aMatrix = new SpiralMatrix();
		System.out.println(aMatrix.spiralOrder(matrix));

	}

}
