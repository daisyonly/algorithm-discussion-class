package inter_prepare;

public class GCD {
	public int getgcd(int a,int b){
		if(a>b) return getgcd(b, a);
		if(a==0) return b;
		return getgcd(a, b%a);
	}
	public static void main(String[] args) {
		GCD testGcd = new GCD();
		System.out.println(testGcd.getgcd(6, 5));
	}

}
