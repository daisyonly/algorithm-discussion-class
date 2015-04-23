package week14;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegersOfMine {
	public int divide(int dividend, int divisor){
		return divideL(dividend, divisor);
	}
	private int divideL(long dividend, long divisor) {
		if (divisor == 1) return (int) dividend;
		if(divisor < 0) return -divideL(dividend, -divisor);
		if(dividend < 0) return -divideL(-dividend, divisor);
		if (divisor > dividend) return 0;
		if (divisor == 0)
			return Integer.MAX_VALUE;
		long d = divisor;
		long bitcnt = 1;
		long ans = 0;
		while (d < dividend) {
			d <<= 1;
			bitcnt <<= 1;

		}
		while (d >= divisor) {
			while (dividend >= d) {
				dividend -= d;
				ans += bitcnt;
			}
			d >>= 1;
			bitcnt >>= 1;
		}
		return (int) ans;
	}

	public int divide2(int dividend, int divisor) {
		/******* handling the case of overflow *******/
		if (divisor == 1)
			return dividend;
		if (dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1)
			return Integer.MAX_VALUE;
		/*********************************************/

		int sign = (dividend > 0 ^ divisor > 0) ? -1 : 1;

		long ans = 0;
		long end = Math.abs((long) dividend);// 因为
		long sor = Math.abs((long) divisor);

		while (end >= sor) {
			long temp = sor;
			long power = 1;
			while ((temp << 1) < end) {
				power <<= 1;
				temp <<= 1;
			}
			ans += power;
			end -= temp;
		}
		return (int) (sign * ans);
	}

	public static void main(String[] args) {
		DivideTwoIntegersOfMine aDivideTwoIntegers = new DivideTwoIntegersOfMine();
		System.out.println(aDivideTwoIntegers.divide(-2147483648, 2));
		System.out.println(Math.abs(Integer.MAX_VALUE));
	}

}
