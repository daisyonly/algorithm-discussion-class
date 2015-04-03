package week10.copy;

//https://leetcode.com/problems/powx-n/
public class PowXDotN {
	
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
    	PowXDotN a  = new PowXDotN();
    	System.out.println(a.pow(8.84372, -5));
    }

}
