package ms.wy;

import java.util.Scanner;

public class FarthestPoint {
	
	
		public static void main(String[] args) {
			Scanner cin = new Scanner(System.in);
			while(cin.hasNext()){
				double x = cin.nextDouble();
				double y = cin.nextDouble();
				double r = cin.nextDouble();
				double eps = 1e-7;
				double ans=0;

				int ansx=0,ansy=0;
				for(int i=200000;i>=-200000;i--){
					double t = r*r - (i-x)*(i-x);
					//if(i == 6) System.out.println(t);
					if(t<-eps) continue;
					int iy = (int) (Math.sqrt(t) + y);
					for (int j = iy + 5; j >= iy - 5; j--) {
						double tmp2 = (j-y)*(j-y) + (i-x)*(i-x);
						if (tmp2<=r*r+eps && tmp2 > ans + eps) {
							ans = tmp2;
							ansx = i;
							ansy = j;
						}
					}
					iy = (int) ( y-Math.sqrt(t));
					for (int j = iy + 5; j >= iy - 5; j--) {
						double tmp2 = (j-y)*(j-y) + (i-x)*(i-x);
						if (tmp2<=r*r+eps && tmp2 > ans + eps) {
							ans = tmp2;
							ansx = i;
							ansy = j;
						}
					}
				}
				System.out.println(ansx+" "+ansy);
			}
		}


}
