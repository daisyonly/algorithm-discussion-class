package july_1;

public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int count=0;
		while(n!=m){
			m=m>>1;
			n=n>>1;
			count++;
		}
		
		return m<<count;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDofNumbersRange anDofNumbersRange=new BitwiseANDofNumbersRange();
		System.out.println(anDofNumbersRange.rangeBitwiseAnd(5, 7));

	}

}
