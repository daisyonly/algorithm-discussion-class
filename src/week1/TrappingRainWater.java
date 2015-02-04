package week1;

public class TrappingRainWater {
	
	private int count(int left, int right, int hight){
		int tmp = (left < right ? left:right)-hight;
		int ans = tmp>0 ? tmp:0;
		return ans;
	}
	
	public int trap(int[] A) {
		if(A==null||A.length==0) return 0;
		int[] maxleft = new int[A.length];
		int[] maxright = new int[A.length];
		int maxtmp = A[0];
		for(int i=1; i < A.length;i++){
			maxleft[i] = maxtmp;
			maxtmp = maxtmp > A[i] ? maxtmp:A[i];
		}
		maxtmp=A[A.length-1];
		for(int i=A.length-2; i >= 0; i--){
			maxright[i]=maxtmp;
			maxtmp = maxtmp > A[i] ? maxtmp:A[i];
		}
		int ans=0;
		for(int i=1; i < A.length-1; i++){
			ans=ans+ count(maxleft[i],maxright[i],A[i]);
		}
		return ans;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater tmp= new TrappingRainWater();
		int[] A= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(tmp.trap(A));

	}

}
