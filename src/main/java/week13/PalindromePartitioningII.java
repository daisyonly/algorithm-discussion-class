package week13;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {
	public int minCut(String s) {
		int len = s.length();
		int D[] = new int[len + 1];
		boolean P[][] = new boolean[len][len];
		// the worst case is cutting by each char
		for (int i = 0; i <= len; i++)
			D[i] = len - i;
	
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || P[i + 1][j - 1])) {
					P[i][j] = true;
					D[i] = Math.min(D[i], D[j + 1] + 1);
				}
			}
		}
		return D[0] - 1;
	}
	//这个比较好
	public int minCut2(String s) {
        int n = s.length();
        boolean isPal[][] = new boolean[n][n];
        int cut[] = new int[n];
        for (int j = 0; j < n; j++) {
            cut[j] = j;
            for (int i = 0; i <= j; i++) {
                //如果子串 s[i...j]是回文串
                if (s.charAt(i) == s.charAt(j)
                        && (j - i < 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (i > 0)
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    else
                        cut[j] = 0; //如果 s[0...j]是回文串，则说明不需要切割
                }
            }
        }
        return cut[n - 1];
    }
 
}
