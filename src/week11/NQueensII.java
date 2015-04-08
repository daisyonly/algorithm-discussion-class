package week11;

//https://leetcode.com/problems/n-queens-ii/
public class NQueensII {
	private int ans=0 ;
	private boolean[] checkCol;
	private boolean[] checkDia1;
	private boolean[] checkDia2;
	private int[] position;
	
	public int totalNQueens(int n) {
    	checkCol = new boolean[n];
    	checkDia1 = new boolean[2*n];
    	checkDia2 = new boolean[2*n];
    	position = new int[n];
    	dfs(0,n);
    	return ans;       
    }

	private void dfs(int raw,int n) {
		if(raw == n ){
			ans++;
		}
		
		for(int i=0;i<n;i++){
			if(check(raw,i,n)){
				position[raw] = i;
				checkCol[i]= true;
				checkDia1[i+raw] = true;
				checkDia2[raw-i+n]= true;
				dfs(raw +1,n);
				checkCol[i]= false;
				checkDia1[i+raw] = false;
				checkDia2[raw-i+n]= false;
			}
		}
	}

	private boolean check(int i,int j,int n) {
		if(!checkCol[j] && !checkDia1[i+j] && ! checkDia2[i-j+n]) return true;
		return false;
	}
	public static void main(String[] args){
		NQueensII a = new NQueensII();
		System.out.println(a.totalNQueens(4));
	}
}
