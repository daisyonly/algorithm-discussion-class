package week11;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
	class Pair {
		int x,y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private boolean check(int i,int j,int n,int m){
		if(i>=0 &&i<n &&j>=0&&j<m) return true;
		else return false;
	}
		
    public void solve(char[][] board) {
    	if(board == null || board.length ==0) return;
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        boolean[][] flag = new boolean[board.length][board[0].length];
        Queue<Pair> queue= new LinkedList<Pair>();
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(!( i==0 || j==0 ||i==n-1 || j==m-1)) continue;
        		if(!flag[i][j] && board[i][j] == 'O'){
        			flag[i][j]= true;
        			queue.add(new Pair(i,j));
        			while(!queue.isEmpty()){
        				Pair cur = queue.poll();
        				board[cur.x][cur.y] ='#';
        				for(int k=0; k<4; k++){
        					int x = cur.x+dx[k];
        					int y = cur.y+dy[k];
            				if(check(x,y,n,m)&&!flag[x][y] && board[x][y] == 'O'){
            					flag[x][y]= true;
            					queue.add(new Pair(cur.x+dx[k],cur.y+dy[k]));
            				}
            			}
        			}
        		}
        	}
        }
        for(int i=0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(board[i][j] =='#') board[i][j] ='O';
        		else if(board[i][j] =='O') board[i][j] ='X';
        	}
        }
        
    }
    
    public static void main(String[] args){
    	char[][] c = new char[4][5];
    	for(int i=0;i<c.length;i++){
    		for(int j=0;j<c[0].length;j++){
    			c[i][j] ='X';
    		}
    	}
    	c[1][1]= 'O';c[1][2]= 'O';c[2][2]= 'O';c[3][1]= 'O';
    	SurroundedRegions a= new SurroundedRegions();
    	a.solve(c);
    	for(int i=0;i<c.length;i++){
    		for(int j=0;j<c[0].length;j++){
    			System.out.print(c[i][j] +" ");
    		}
    		System.out.println();
    	}
    	System.out.println(c[0].length);
    }

}
