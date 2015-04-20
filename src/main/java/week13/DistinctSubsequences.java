package week13;

//https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
	
    public int numDistinct(String S, String T) {
    	int dp[][] = new int[S.length()+1][T.length()+1];
    	dp[0][0] = 1;
    	for(int i=0;i<S.length();i++){
    		dp[i+1][0] = 1;
    	}
    	for(int i=0;i<S.length();i++){
    		for(int j=0;j<T.length();j++){
    			if(S.charAt(i)==T.charAt(j)){
    				dp[i+1][j+1] = dp[i][j+1] + dp[i][j];
    			}else{
    				dp[i+1][j+1] = dp[i][j+1];
    			}
    		}
    	}
		return dp[S.length()][T.length()];        
    }
    public static void main(String[] args) {
    	DistinctSubsequences aDistinctSubsequences = new DistinctSubsequences();
    	System.out.println(aDistinctSubsequences.numDistinct("ccc","c"));
	}

}
