package fre3;

//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		boolean dp[][] = new boolean[p.length()+1][s.length()+1];
		dp[0][0] = true;
		for(int i=0;i<p.length();i++){
			if(p.charAt(i) !='*') dp[i+1][0]= false;
			else dp[i+1][0] = dp[i][0];
		}
		for(int i=0;i<p.length();i++){
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)==p.charAt(i)||p.charAt(i)=='?') dp[i+1][j+1] =dp[i][j];
				else if(p.charAt(i) == '*'){
					for(int k=-1;k<j;k++){
						dp[i+1][j+1] =dp[i+1][j+1]||dp[i][k+1]; 
					}
					boolean tmp = dp[i+1][j+1];
					while(++j<s.length()){
						dp[i+1][j+1] = tmp;
					}
					break;
				}else{
					dp[i+1][j+1] = false;
				}
			}
		}
		return dp[p.length()][s.length()];      
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching a = new WildcardMatching();
		System.out.println(a.isMatch("aa", "*"));

	}

}
