package week14;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor){
		if(dividend == Integer.MIN_VALUE && Math.abs(divisor)==1 ||divisor==0){
			return Integer.MAX_VALUE;
		}
		
		int sign = (dividend >0 ^ divisor>0)? -1:1;
		long dividendLong = dividend;
		long divisorLong = divisor;
		
		
		return divisor;
		
	}
	

	public static void main(String[] args) {
		DivideTwoIntegers aDivideTwoIntegers = new DivideTwoIntegers();
		System.out.println(aDivideTwoIntegers.divide(-2147483648, 2));
		System.out.println(Math.abs(Integer.MAX_VALUE));
	}

}
