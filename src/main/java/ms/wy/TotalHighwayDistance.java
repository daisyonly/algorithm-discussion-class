package ms.wy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;

public class TotalHighwayDistance {

	static int N = 100007;
	static int left[] = new int[N];
	static int fa[] = new int[N];
	static long sum = 0;
	static Map<String, Integer> mp = new HashMap<String, Integer>();
	static int n,m;
	
	static void dfs(int x,List<Integer> edge[]){
		for(int to : edge[x]){
			if(to!=fa[x]){
				fa[to]=x;
				dfs(to,edge);
				left[x]+=left[to];
			}
		}
		left[x]++;
		for(int to:edge[x]){
			if(to!=fa[x]){
				int v = mp.get(to+"#"+x);
				sum+=(long)left[to]*v*(n-left[to]);
			}
		}
		
	}
	public static void main(String[] args) {
		
		List<Integer> edge[] = new List[N];
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		for(int i=0;i<=n;i++) edge[i] = new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int a = cin.nextInt();
			int b = cin.nextInt();
			int v = cin.nextInt();
			edge[a].add(b);
			edge[b].add(a);
			mp.put(a+"#"+b, v);
			mp.put(b+"#"+a, v);
		}
		dfs(1,edge);
		//System.out.println(sum);
		for(int i=0;i<m;i++){
			String op = cin.next();
			if(op.charAt(0) == 'E'){
				int to = cin.nextInt();
				int x = cin.nextInt();
				int v2 = cin.nextInt();
				if(to == fa[x]) {
					int tmp = x;
					x = to;
					to = tmp;
				}
				if(to!=fa[x]){
					int v = mp.get(to+"#"+x);
					sum-=(long)left[to]*v*(n-left[to]);
					//System.out.println(left[to]);
					sum+=(long)left[to]*v2*(n-left[to]);
					mp.put(to+"#"+x, v2);
				}
			}else{
				System.out.println(sum);
			}
		}
	}

}
