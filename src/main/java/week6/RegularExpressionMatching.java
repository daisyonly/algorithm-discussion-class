package week6;

//https://oj.leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
	
	 public boolean isMatch(String s, String p) {
			boolean[][] dp = new boolean[s.length()+1][p.length()+1];
			dp[0][0] =true;
			for(int i=1; i<s.length()+1;i++){
				dp[i][0] = false;
			}
			for(int j=1; j<p.length()+1;j++){
				if(p.charAt(j-1)!='*') dp[0][j] = false;
				else{
					dp[0][j] = dp[0][j-2];
				}
			}
			for(int i=1;i<s.length()+1;i++){
				for(int j=1;j<p.length()+1;j++){
					if(p.charAt(j-1)!='*'){
						if(p.charAt(j-1) =='.'||p.charAt(j-1) == s.charAt(i-1)){
							if(j>=3 && p.charAt(j-2)=='*')
							    dp[i][j] = dp[i-1][j-1] || dp[i-1][j-3];
							else{
								dp[i][j]= dp[i-1][j-1];
							}						
						}
						else 
							dp[i][j] = false;
					}
					else{
						if(p.charAt(j-2) == s.charAt(i-1)||p.charAt(j-2)=='.'){
							dp[i][j] = dp[i][j-1]||dp[i-1][j];
						}
						if(j>=2)
							dp[i][j] = dp[i][j] || dp[i][j-2];
						else
							dp[i][j] = false;
					}
				}
			}
	    	return dp[s.length()][p.length()];       
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
