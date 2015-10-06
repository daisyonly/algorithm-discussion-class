package ms.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class TotalHighwayDistance {
	static HashMap<String, Integer> map=new HashMap<String, Integer>();
	static List<Integer> edge[];
	static int fa[];
	static int left[];
	static int sum;
	static int n;
	
	
	public static void main(String[] args) {
		Scanner cin =new Scanner(System.in);
		n=cin.nextInt();
		int m=cin.nextInt();
		edge=new List[n+1];
		fa=new int[n+1];
		left=new int[n+1];
		sum=0;
		for(int i=0;i<=n;i++) edge[i] = new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int a=cin.nextInt();
			int b=cin.nextInt();
			int v=cin.nextInt();
			edge[a].add(b);
			edge[b].add(a);
			map.put(a+"#"+b, v);
			map.put(b+"#"+a, v);
		}
		dfs(1);
		for(int i=0;i<m;i++){
			String command=cin.next();
			if(command.charAt(0)=='E'){
				int a=cin.nextInt();
				int b=cin.nextInt();
				int v=cin.nextInt();
				int oldv=map.get(a+"#"+b);
				if(fa[a]==b){
					int tmp=a;
					a=b;
					b=tmp;
				}
				sum=sum+(v-oldv)*left[b]*(n-left[b]);
				map.put(a+"#"+b, v);
				map.put(b+"#"+a, v);
			}else {
				System.out.println(sum);
			}
		}
		
	}


	private static void dfs(int x) {
		for(int to:edge[x]){
			if(fa[x]!=to){
				fa[to]=x;
				dfs(to);
				left[x]=left[x]+left[to];
			}
		}
		left[x]++;
		for(int to:edge[x]){
			if(fa[x]!=to){
				int v = map.get(to+"#"+x);
				sum=sum+left[to]*v*(n-left[to]);
			}
		}		
	}

}
