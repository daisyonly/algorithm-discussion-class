package jisuanzhidao;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m= cin.nextInt();
		int nums[]=new int[n];
		boolean isP[][]= new boolean[n][n];
		int sums[][]= new int[n][n];
		for(int i=0;i<n;i++){
			nums[i]=cin.nextInt();
		}
		
		for(int i=0; i < n; i++){
			for(int j=0; j<=i; j++){
				if(nums[j] == nums[i]&&(i-j<2||isP[j+1][i-1])){
					isP[j][i] = true;
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				if(i==j) sums[j][i]=nums[i];
				else{
					sums[j][i]=sums[j][i-1]+nums[i];
				}
			}
		}
		
		while((m--)>0){
			int l = cin.nextInt();
			int r = cin.nextInt();
			int sum=0;
			for(int i=l-1;i<=r-1;i++){
				for(int j=l-1;j<=i;j++){
					if(isP[j][i]) {
						sum+=sums[j][i];						
					}
				}
			}
			System.out.println(sum);
			cin.close();
		}
	}

}
