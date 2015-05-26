package greedy;


public class Candy {
	 public int candy(int[] ratings) {
		int sum =0;
		int cnt=1;
		int n= ratings.length;
		int ans[] = new int[ratings.length]; 
		for(int i=0;i<n;i++){
			ans[i] = cnt;
			if(i<n-1 && ratings[i]<ratings[i+1]) ++cnt;
			else cnt =1;
		}
		cnt = 1;
		for(int i=n-1;i>=0;i--){
			ans[i] = ans[i]>cnt? ans[i]:cnt;
			if(i>0 && ratings[i]<ratings[i-1]) ++cnt;
			else cnt = 1;
		}
		for(int i=0;i<n;i++) {
			//System.out.println(ans[i]);
			sum +=ans[i];
		}
		return sum;        
	 }
	 public static void main(String[] args) {
		 Candy aCandy = new Candy();
		 int ratings[] ={2,1};
		 System.out.println(aCandy.candy(ratings));
	}
}
