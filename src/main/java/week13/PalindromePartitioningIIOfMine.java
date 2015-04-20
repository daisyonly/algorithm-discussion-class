package week13;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningIIOfMine {
	public int minCut(String s) {
		int len = s.length();
		int cnt[] = new int[len];
		boolean isP[][] = new boolean[len][len];
		for(int i=0; i < len; i++){
			cnt[i] = i;
			for(int j=0; j<=i; j++){
				if(s.charAt(j) == s.charAt(i)&&(i-j<2||isP[j+1][i-1])){
					isP[j][i] = true;
					if(j!=0){
						cnt[i] = Math.min(cnt[i], cnt[j-1]+1);
					}else{
						cnt[i] = 0;
					}
				}
			}
		}
		return cnt[len-1];	
	}
 
}
