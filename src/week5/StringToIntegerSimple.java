package week5;

public class StringToIntegerSimple {
	public int atoi(String str) {
		if(str == null||str.length()==0)return 0;
	    int sign = 1, base = 0, i = 0;
	    char[] c = str.toCharArray();
	    while (i < c.length && c[i] == ' ') { i++; }
	    if (c[i] == '-' || c[i] == '+') {
	        sign = 1 - 2 * (c[i++] == '-' ? 1:0); 
	    }
	    while ( i < c.length && c[i] >= '0' && c[i] <= '9') {
	        if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && c[i] - '0' > Integer.MAX_VALUE%10)) {
	            if (sign == 1) return Integer.MAX_VALUE;
	            else return Integer.MIN_VALUE;
	        }
	        base  = 10 * base + (c[i++] - '0');
	    }
	    return base * sign;
	}
	public static void main(String[] args) {
		StringToIntegerSimple aIntegerSimple = new StringToIntegerSimple();
		System.out.println(aIntegerSimple.atoi("-2147483649"));
		System.out.println(Integer.MAX_VALUE+"   "+Integer.MIN_VALUE);
	}

}
