package week13;

//https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
	//dp[i][j]表示s1的前i个字符和s2的前j个字符能否和s3的前i+j个字符匹配
	 public boolean isInterleave(String s1, String s2, String s3) {
		 if(s1.length()+s2.length()!= s3.length()) return false;
		 boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
		 dp[0][0] = true;
		 for(int i=0;i<s1.length();i++){
			 if(s1.charAt(i)==s3.charAt(i))
				 dp[i+1][0] = true;
		 }
		 for(int i=0;i<s2.length();i++){
			 if(s2.charAt(i)==s3.charAt(i))
				 dp[0][i+1] = true;
		 }
		 for(int i=0;i<s1.length();i++){
			 for(int j=0;j<s2.length();j++){
				 int k = i + j + 1;
				 if(s3.charAt(k) == s1.charAt(i)){
					 dp[i+1][j+1] = dp[i][j+1];
				 }
				 if(s3.charAt(k) == s2.charAt(j)){
					 dp[i+1][j+1] = dp[i+1][j+1]||dp[i+1][j];
				 }
			 }
		 }
		 return dp[s1.length()][s2.length()];
    
     }
	 public static void main(String[] args) {
		 InterleavingString aInterleavingString = new InterleavingString();
		 System.out.println(aInterleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

}
