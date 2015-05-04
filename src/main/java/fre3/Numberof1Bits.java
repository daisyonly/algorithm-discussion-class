package fre3;


//http://stackoverflow.com/questions/109023/how-to-count-the-number-of-set-bits-in-a-32-bit-integer
public class Numberof1Bits {
	 public int hammingWeight(int n) {
	   int ans =0;  	
	   while(n!=0){
		   n=n&(n-1);
		   ans++;
	   }     
	   return ans;
	 }
	
	// you need to treat n as an unsigned value
    public int hammingWeight2(int i) {
    	i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits a = new Numberof1Bits();
		System.out.println(a.hammingWeight(8));

	}

}
