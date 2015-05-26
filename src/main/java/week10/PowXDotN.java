package week10;

//https://leetcode.com/problems/powx-n/
public class PowXDotN {
	
	 public double pow2(double x, int n) {
	        double result = 1.0;
	        if(n<0){
	            x = 1/x;
	            n = -n;
	        }
	        while(n>0){
	            if((n&1)==1){
	                result *= x;
	            }
	            n >>=1;
	            x = x*x;
	        }
	        return result;
	 }

	
    public double pow(double x, int n) {
		double[] tmp = new double[35];
		tmp[0] = 1;tmp[1] = x;
		for(int i = 2; i <= 32; i++){
			tmp[i] = tmp[i-1] * tmp[i-1];
		}
    	int count = 1;
    	double sum= 1;
    	int y = n < 0 ? -n:n;
    	while(y > 0){
    		if( y % 2 != 0){
    			sum = sum * tmp[count];
    		}
    		++count;
    		y = y >>1;
    	}
    	return n<0 ? 1/sum:sum;
        
    }
    public static void main(String[] args){
    	//PowXDotN a  = new PowXDotN();
    	//System.out.println(a.pow2(34.00515, -3));
    	
    	//double a = 99.0123456789123456789d;
    	//double b = 99.0123456789123456788d;
    	double a = 99.01234567891233;
    	double b = 99.01234567891234;
    	double c = a-b;
    	System.out.println(a==b);
    	System.out.println(c);
    	System.out.println(1e-1);
    	if((a - b)<(1e-13)){
    	System.out.println("a = b");
    	}
    	else {
    	System.out.println("a != b");
    	}
    }

}
