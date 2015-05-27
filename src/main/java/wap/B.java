package wap;

import java.io.*;
import java.util.*;

public class B {
	
	public final static  int N = 100001;
	public static Queue<Integer> q = new LinkedList<Integer>();
	//int first[N],next[N<<1],ver[N<<1],d[N],tot;
	public static int first[],next[],ver[],d[],tot=0;
	static void add(int a,int b)
	{
	    ver[++tot]=b;
	    next[tot]=first[a];
	    first[a]=tot;
	}
	static void bfs()
	{
	    int x;
	    while (!q.isEmpty())
	    {
	        x=q.poll();
	        for (int p=first[x];p!=0;p=next[p])
	            if (d[x]+1<d[ver[p]])
	            {
	                d[ver[p]]=d[x]+1;
	                q.offer(ver[p]);
	            }
	    }
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
       
		int n,m,a,b;
	    n = cin.nextInt();
        m = cin.nextInt();
	    for (int i=1;i<n;i++)
	    {
	        a = cin.nextInt();
	        b = cin.nextInt();
	        add(a,b);
	        add(b,a);
	    }
	    for (int i=1;i<=n;i++) d[i]=n;
	    d[1]=0;
	    q.offer(1);
	    bfs();
	    while ((m--)!=0)
	    {
	    	a = cin.nextInt();
	        b = cin.nextInt();
	        if (a==1)
	        {
	            d[b]=0;
	            q.offer(b);
	        }
	        else
	        {
	            bfs();
	            System.out.println(d[b]);
	        }
	    }
	    cin.close();
	}

}
/*
 * 
 * #include<cstdio>
#include<cstdlib>
#include<cstring>
#include<algorithm>

using namespace std;

const int MAXN = 200005;
int n,m,a,b;
int Q[MAXN],ds[MAXN],st[MAXN];
int V[MAXN*2],N[MAXN*2],F[MAXN];
int tot = 0,top,hd = 0,tl = 0;
bool v[MAXN];
void add(int a,int b)
{
    ++tot;
    V[tot] = b;
    N[tot] = F[a];
    F[a] = tot;
}
void spread()
{
    while (hd != tl)
    {
        int nw = Q[++hd];
        for (int p = F[nw]; p > 0; p = N[p])
            if (ds[V[p]] > ds[nw] + 1)
            {
                ds[V[p]] = ds[nw] + 1;
                Q[++tl] = V[p];
            }
    }hd = 0,tl = 0;
}
int main()
{
//    freopen("in.txt","r",stdin);
//    freopen("out.txt","w",stdout);
    memset(F,0,sizeof(F));
    memset(N,0,sizeof(N));
    scanf("%d%d",&n,&m);
    for (int i = 1; i < n; i ++)
       scanf("%d%d",&a,&b),add(a,b),add(b,a);
       
    for (int i =1; i <= n; i ++)
        ds[i] = n +10;
    ds[Q[++tl] = 1] = 0;
    
    for (int i =1; i <= m; i ++)
    {
        scanf("%d%d",&a,&b);
        if (a == 1)
            ds[Q[++tl] = b] = 0;
        else spread(),printf("%d\n",ds[b]);
    }
    
    return 0;
}
*/
