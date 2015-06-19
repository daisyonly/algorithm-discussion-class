package inter_prepare;

public class Test {
	public static String ans;
	public static int len = -1;
	
	public static void main(String[] args) {
		String str = "ccabcab";
		char c[] = str.toCharArray();
		for(int i=0;i<c.length;i++){
			for(int j=i+1;j<c.length;j++){
				for(int k=0;j+k<c.length&&c[i+k] == c[j+k];k++){
					if(k>len){
						len = k;
						ans = str.substring(i,i+k+1);
					}
				}
			}
		}
		System.out.println(ans);
	}

}
