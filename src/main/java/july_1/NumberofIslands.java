package july_1;

public class NumberofIslands {
	int dx[]={0,-1,0,1};
	int dy[]={-1,0,1,0};
	public int numIslands(char[][] grid) {
		if(grid==null || grid.length==0) return 0;
		int ans=0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					ans++;
					dfs(grid,i,j);
				}
			}
		}		
		return ans;	
	}

	private void dfs(char[][] grid, int x, int y) {
		grid[x][y]='x';
		for(int i=0;i<4;i++){
			int newx=x+dx[i],newy=y+dy[i];
			if(check(newx,newy,grid)&&grid[x+dx[i]][y+dy[i]]=='1'){
				dfs(grid, newx, newy);
			}
		}	
	}

	private boolean check(int newx, int newy, char[][] grid) {
		return newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofIslands aIslands=new NumberofIslands();
		char c[][]={{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		System.out.print(aIslands.numIslands(c));
		

	}

}
