package fre3;


//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
		char c1[] = num1.toCharArray();
		char c2[] = num2.toCharArray();
		int total = c1.length+c2.length;
		char tmp[][] = new char[c2.length][c1.length+c2.length]; 
		for(int i=c2.length-1;i>=0;i--){
			tmp[i] = mutiplyOp(total,c1,c2[i],c2.length-1-i); 
		}
		return addOp(tmp);
	        
	}
    //不足全部高位补0
	private char[] mutiplyOp(int total,char[] c1, char c,int count) {
	    StringBuilder sb = new StringBuilder();
	    int flag = 0;
	    int i=c1.length-1;
	    int num = c-'0';
	    for(int j=0;j<count;j++) sb.append('0');
	    while(i>=0){
	    	int tmp = (c1[i]-'0')*num+flag;
	    	sb.append(tmp%10);
	    	flag = tmp/10;
	    	i--;
	    }
	    if(flag!=0) sb.append(flag);
	    while (sb.length()<total) {
			sb.append('0');
		}
		return sb.toString().toCharArray();
	}

	private String addOp(char[][] tmp) {
		StringBuilder sb = new StringBuilder();
		int flag = 0;
		for(int j=0;j<tmp[0].length;j++){
			int sum=flag;
			for(int i=0;i<tmp.length;i++){
				sum += tmp[i][j]-'0'; 
			}
			sb.append(sum%10);
			flag = sum/10;
		}
		while(sb.length()>1&&sb.charAt(sb.length()-1)=='0') sb.deleteCharAt(sb.length()-1);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings aMultiplyStrings = new MultiplyStrings();
		System.out.println(aMultiplyStrings.multiply("6", "501"));

	}

}
