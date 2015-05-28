package wap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n,m,a,b;
	    n = cin.nextInt();
        m = cin.nextInt();
		int edge[][] = new int[n+1][n+1];
        Queue<Integer> que = new LinkedList<Integer>();
        int d[] = new int[n+1];
        for(int i=1;i<n;i++){
        	a = cin.nextInt();
            b = cin.nextInt();
        	edge[a][b]=1;
        	//edge[b].add(a);
        	d[i]=n;
        }
        d[1] =0;
        que.add(1);
        while((m--)!=0){
        	a = cin.nextInt();
            b = cin.nextInt();
            if(a==1){
            	d[b]=0;
            	que.add(b);
            }else{
            	bfs(edge,que,d);
            	System.out.println(d[b]);
            }
        }
	}

	private static void bfs(LinkedList<Integer>[] edge, Queue<Integer> que,
			int[] d) {
		while(!que.isEmpty()){
			int x = que.poll();
			for(int nextNode:edge[x]){
				if(d[nextNode] > d[x]+1){
					d[nextNode] = d[x]+1;
					que.add(nextNode);
				}
			}
		}	
	}

}
