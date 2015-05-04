package fre3;
//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		boolean dp[][] = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		for(int i=0;i<p.length();i++){
			if(p.charAt(i) !='*') dp[0][i+1]= false;
			else dp[0][i+1] = dp[0][i];
		}
		for(int i=0;i<p.length();i++){
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)==p.charAt(i)||p.charAt(i)=='?') dp[i+1][j+1] =dp[i][j];
				else if(p.charAt(i) =='*'){
					dp[i+1][j+1]=dp[i][j];
				}else{
					dp[i+1][j+1] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
