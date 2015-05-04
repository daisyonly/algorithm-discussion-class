package fre4;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
	
	public int numDecodings(String s) {
		if(s.length()==0||s.charAt(0)=='0') return 0;
		int dp[] = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=1;i<s.length();i++){
			int tmp = (s.charAt(i-1)-'0')*10+s.charAt(i)-'0';
			if(tmp<10 && tmp>0){
				dp[i+1] = dp[i];
			}else if(tmp<27 && tmp>0 && tmp%10==0){
				dp[i+1] = dp[i-1];
			}else if(tmp<27 && tmp >0 && tmp%10!=0){
				dp[i+1] = dp[i-1] + dp[i];
			}else if(tmp >=27 && tmp%10 !=0){
				dp[i+1] = dp[i];
			}
			else return 0;
		}
		//System.out.println(s.length());
		return dp[s.length()];        
    }

	public static void main(String[] args) {
		DecodeWays aDecodeWays = new DecodeWays();
		System.out.println(aDecodeWays.numDecodings("100"));
	}

}
