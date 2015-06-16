package inter_prepare;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Exam2 {
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int n,m,a,b;
		in.nextToken();
        n = (int)in.nval;
        in.nextToken();
        m = (int)in.nval;
        @SuppressWarnings("unchecked")
		LinkedList<Integer> edge[] = new LinkedList[n+1];
        Queue<Integer> que = new LinkedList<Integer>();
        int d[] = new int[n+1];
        for(int i=1;i<=n;i++){
        	edge[i] = new LinkedList<Integer>();
        	d[i]=n;
        }
        for(int i=1;i<n;i++){
        	in.nextToken();
            a = (int)in.nval;
            in.nextToken();
            b = (int)in.nval;
            //out.println("\ntest:"+a+" "+b);
        	edge[b].add(a);
        	edge[a].add(b);
        }
        d[1] =0;
        que.add(1);
        while((m--)!=0){
        	in.nextToken();
            a = (int)in.nval;
            in.nextToken();
            b = (int)in.nval;
            if(a==1){
            	d[b]=0;
            	que.add(b);
            }else{
            	bfs(edge,que,d);
            	out.println(d[b]);
            }
        }
        out.flush();
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
