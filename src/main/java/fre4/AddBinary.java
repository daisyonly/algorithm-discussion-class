package fre4;

public class AddBinary {
	public String addBinary(String a, String b) {
		char aChar[] = a.toCharArray();
		char bChar[] = b.toCharArray();
		StringBuilder ans = new StringBuilder();
		int flag = 0;
		int i=a.length()-1;
		int j=b.length()-1;
		while(i>=0&&j>=0){
			int tmp = aChar[i]-'0'+bChar[j]-'0'+flag;
			ans.append(tmp%2);
			flag = tmp/2;
			i--;
			j--;
		}
		while(i>=0){
			int tmp = aChar[i]-'0'+flag;
			ans.append(tmp%2);
			flag = tmp/2;
			i--;
		}
		while(j>=0){
			int tmp =  bChar[j]-'0'+flag;
			ans.append(tmp%2);
			flag = tmp/2;
			j--;
		}
		if(flag!=0) ans.append(flag);
		return ans.reverse().toString();
        
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("11", "1"));
		

	}

}
