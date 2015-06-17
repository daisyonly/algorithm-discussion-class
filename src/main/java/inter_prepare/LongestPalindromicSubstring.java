package inter_prepare;

//http://fisherlei.blogspot.com/2012/12/leetcode-longest-palindromic-substring.html
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int n=s.length();
		boolean isP[][] = new boolean[n][n];
		int maxL=0,start=0,end=0;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				if(s.charAt(i)==s.charAt(j)&&
						(i-j<2||isP[j+1][i-1])){
					isP[j][i]= true;
					if(maxL<(i-j+1)){
						maxL=i-j+1;
						start = j;
						end=i;
					}
				}
			}
		}
		return s.substring(start, end+1);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring a = new LongestPalindromicSubstring();
		System.out.println(a.longestPalindrome("abcbajj"));

	}

}
