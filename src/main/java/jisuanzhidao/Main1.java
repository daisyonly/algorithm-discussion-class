package jisuanzhidao;

import java.util.Scanner;
import java.lang.Math;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int t=cin.nextInt();
		while((t--)>0){
			int m=cin.nextInt();
			int rs[]=new int[360];
			for(int i=0;i<m;i++){
				int r=cin.nextInt();
				int left=cin.nextInt()+90;
				int right=cin.nextInt()+90;
				for(int j=left;j<right;j++){
					if(rs[j]<r) rs[j]=r;
				}
			}
			double sum=0;
			for(int i=0;i<360;i++){
				sum+=Math.PI*rs[i]*rs[i];
			}
			System.out.println(sum/360);
		}

	}

}
