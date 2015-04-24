package week14;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor){
		if(divisor==1) return dividend;
		if(dividend == Integer.MIN_VALUE && Math.abs(divisor)==1 ||divisor==0){
			return Integer.MAX_VALUE;
		}
		
		int sign = (dividend > 0 ^ divisor > 0)? -1:1;
		long dividendLong = Math.abs((long)dividend);
		long divisorLong = Math.abs((long)divisor);
		int bitcnt =1;
		while((divisorLong<<1) <= dividendLong){
			divisorLong = divisorLong<<1;
			bitcnt = bitcnt<<1;
		}
		int ans=0;
		while(dividendLong>=divisor && divisorLong!=0){
			while(dividendLong >= divisorLong){
				dividendLong -= divisorLong;
				ans = ans + bitcnt;
			}
			divisorLong >>= 1;
			bitcnt >>=1;
		}			
		return ans*sign;		
	}
	

	public static void main(String[] args) {
		DivideTwoIntegers aDivideTwoIntegers = new DivideTwoIntegers();
		System.out.println(aDivideTwoIntegers.divide(2147483647, 3));
		//System.out.println(Math.abs(Integer.MAX_VALUE));
	}

}
