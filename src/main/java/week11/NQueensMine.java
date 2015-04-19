package week11;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class NQueensMine {
	private List<String[]> ans = new LinkedList<String[]>();
	private boolean[] checkCol;
	private boolean[] checkDia1;
	private boolean[] checkDia2;
	private int[] position;
	
    public List<String[]> solveNQueens(int n) {
    	checkCol = new boolean[n];
    	checkDia1 = new boolean[2*n];
    	checkDia2 = new boolean[2*n];
    	position = new int[n];
    	dfs(0,n);
    	return ans;       
    }

	private void dfs(int raw,int n) {
		if(raw == n ){
			String [] tmp = new String[n];
			for(int i=0; i<n; i++){
				StringBuffer rowStr = new StringBuffer(n);
				for(int j=0;j<n;j++){
					if(j==position[i]) rowStr.append('Q');
					else rowStr.append('.');
				}
				tmp[i] = rowStr.toString();
			}
			ans.add(tmp);
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
		NQueensMine a = new NQueensMine();
		System.out.println(a.solveNQueens(4).size());
	}
	
}
