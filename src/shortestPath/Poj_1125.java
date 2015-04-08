package shortestPath;

import java.util.*;
import java.io.*;

//http://poj.org/problem?id=1125
public class Poj_1125{
    
    @SuppressWarnings("resource")
	public static void main(String rgs[]) throws Exception
    {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int i,j,k,t=0,e,s,n = cin.nextInt();
        while(n!=0){
            int[][] a=new int[n+1][n+1];
            for(i=1;i<=n;i++)
                Arrays.fill(a[i],0xfffff);
            for(i=1;i<=n;i++){
                t = cin.nextInt();
                for(j=1;j<=t;j++){
                    e = cin.nextInt();
                    s = cin.nextInt();
                    a[i][e]=s;
                }
            }            
            for(k=1;k<=n;k++){
                for(i=1;i<=n;i++){
                    for(j=1;j<=n;j++){
                        if(a[i][k]+a[k][j]<a[i][j])
                            a[i][j]=a[i][k]+a[k][j];
                    }
                }
            }    
            int min=0xfffff,max;
            k=0;        
            for(i=1;i<=n;i++){
                max=0;
                for(j=1;j<=n;j++){
                    if(i!=j && a[i][j]>max)
                        max=a[i][j];
                }
                if(max<min){
                    min=max;
                    k=i;
                }
            }
            if(k>0)
                System.out.println(k+" "+min);
            else
                System.out.println("disjoint");
            n = cin.nextInt();
        }
    }
}

