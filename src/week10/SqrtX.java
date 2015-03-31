package week10;

// https://leetcode.com/problems/sqrtx/
public class SqrtX {
	
    public int sqrt(int x) {
    	if(x<4) return 1;
    	int left =1;
    	int right = x;
    	int ans = 0;
		while( left <= right){
			int mid = (left+right)/2;
			if(x/mid < mid){
				right = mid-1;
			}else if(x/mid == mid){
				return mid;
			}else{
				ans = mid;
				left = mid +1;
			}
		}
    	return ans;       
    }
    public static void main(String[] args) {
    	SqrtX a = new SqrtX();
    	System.out.println(a.sqrt(2147483647));
	}

}
