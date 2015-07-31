package shortestPath.bellman;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

//http://128kj.iteye.com/blog/1716385
public class SPFA_2{
  private int map[][];  //邻接矩阵
  private int dist[]; // s到终点的最短路径
  //private int[] Path;// 记录前驱点 。若Path[i]=k,表示从s到i的最短路径中i的前一个点是k
  static final int INF=10000;   
  private int n;//顶点个数
  private int s;//起点
  private int e;//终点  


    public SPFA_2(int n,int s,int e,int[][] map){
           this.n=n;
           this.s=s;
           this.e=e;
           this.map=map;
           dist = new int[n];
     }

  public int[] getDist(){
      return dist;
   }
  
  private void spfa(){  
    int x;  
    Queue<Integer> q=new LinkedList<Integer>() ;  
    boolean  visited[]=new boolean[n];  
    for(int i=0;i<n;i++)  
            dist [i]=INF;  
    dist[s]=0;  
    q.offer(s);  
    visited[s]=true;  
    while(!q.isEmpty()){  
       
        x=q.poll();  
        visited[x]=false;  // 置出队的点未标记   
        for(int i=0;i<n;i++)  
            if(dist[x]+map[x][i]<dist[i])  //这里就是所谓的松弛操作了
            {  
                dist[i]=map[x][i]+dist[x]; //更新路径   
                //Path[i]=x;
                if(!visited[i])  // 未被访问   
                {  
                    q.offer(i);  
                    visited[i]=true;  
                }  
            }  
    }  
  }  
  
   public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n,m,s,e,u,v,w;
          int[][] map;
          while (sc.hasNext()) {
              n = sc.nextInt();//城镇数目即图的顶点数
              m = sc.nextInt();//边数
              map = new int[n][n];
              for (int i = 0; i < n; i++)
               for (int j = 0; j < n; j++)
                 map[i][j] = INF;
             
              while (m-- > 0) {
                   u = sc.nextInt();
                   v = sc.nextInt();
                   w = sc.nextInt();
                   if (map[u][v] > w || map[v][u] > w) {//注意是双向的
                        map[u][v] = w;
                        map[v][u] = w;
                   }
             }
             s = sc.nextInt();
             e = sc.nextInt();
             SPFA_2 ma=new SPFA_2(n,s,e,map);
             ma.spfa();
             int[] dist=ma.getDist();
             if (dist[e] == INF)
                  System.out.println(-1);
             else   System.out.println(dist[e]);
       }
    }
  }

