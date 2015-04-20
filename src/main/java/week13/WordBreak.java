package week13;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict){
		boolean dp[] = new boolean[s.length()+1];//0表示空串，dp[2]表示s[0-1]是否能够分割
		dp[0] = true;
		for(int i=0;i<s.length();i++){
			for(int j=0; j<=i; j++){
				dp[i+1] = dp[j] && dict.contains(s.subSequence(j, i+1));
				if(dp[i+1]) break;
			}
		}	
		return dp[s.length()];		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
