package ms.me;

import java.util.Scanner;

public class FarthestPoint {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while (cin.hasNext() ){
			double x=cin.nextDouble();
			double y= cin.nextDouble();
			double r=cin.nextDouble();
			int max=(int) (x+r+1);
			int min=(int) (x-1);
			double eps=1e-9;
			double ans=0;
			int ansx=0,ansy=0;
			for(int i=max;i>=min;i--){
				double yy=r*r-(x-i)*(x-i);
				if(yy<-eps) continue;
				double tmpy=Math.sqrt(yy);
				int maxy=(int) (y+tmpy+2);
				int miny=(int) (y-1);
				for(int j=maxy;j>=miny;j--){
					double tmp=(i-x)*(i-x)+(j-y)*(j-y);
					if(tmp<=r*r+eps&&tmp>ans+eps){
						ansx=i;
						ansy=j;
						ans=tmp;						
					}
				}
			}
			System.out.println(ansx+" "+ansy);
			
		}
		

	}

}
