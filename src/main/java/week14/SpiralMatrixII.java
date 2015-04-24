package week14;

//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
    	if(n<=0) return new int[0][0];
    	int ans[][] = new int[n][n];
    	int dx[] = {0,1,0,-1};
    	int dy[] = {1,0,-1,0};
    	int count =1;
    	ans[0][0] =1;
    	int curX =0,curY=0;
    	int newX,newY;
    	while(count < n*n){
    		for(int i=0;i<4;i++){
    			while(true){
    				newX = curX+dx[i];
        			newY = curY+dy[i];
        			if(check(newX, newY, n)&& ans[newX][newY]==0){
        				curX = newX;
        				curY = newY;
        				ans[curX][curY]= ++count;
        			}else{
        				break;
        			}
    			}  			
    		}
    	}   	
		return ans;        
    }
    
    private boolean check(int i,int j,int n) {
		if(i>=0&&j>=0 && i < n && j<n) return true;
		return false;
	}
    public static void main(String[] args) {
    	SpiralMatrixII aIi = new SpiralMatrixII();
    	int[][] ans = aIi.generateMatrix(3);
    	System.out.println(ans.length);
    	System.out.println(ans[0].length);
    	for(int i=0;i<ans.length;i++){
    		for(int j=0;j<ans[0].length;j++){
    			System.out.print(ans[i][j]+ "  ");
    		}
    		System.out.println();
    	}
	}

}
