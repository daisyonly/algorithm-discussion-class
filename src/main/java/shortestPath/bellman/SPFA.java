package shortestPath.bellman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SPFA {
	static int nodeCount;
	static int edgeCount;
	static Node[] nodeArray;
	static int [] dist;
	static Queue<Integer> queue;
	static int max = 10000000;
	
	static class Node {

		private HashMap<Integer, Integer> map = null;
		
		public void addEdge(int end, int edge) {
			if (this.map == null) {
				this.map = new HashMap<Integer, Integer>();
			}
			this.map.put(end, edge);
		}
	}	
	
	private static void spfa() {
		queue.offer(1);
		while (!queue.isEmpty()) {
			int index = queue.poll();
			HashMap<Integer, Integer> hm = nodeArray[index].map;
			if (hm == null) {
				continue;
			}
			Set<Integer> s = hm.keySet();
			Iterator<Integer> it = s.iterator();
			while (it.hasNext()) {
				int num = it.next();
				if (dist[index] + hm.get(num) < dist[num]) {
					dist[num] = dist[index] + hm.get(num);
					if (!queue.contains(num)) {
						queue.offer(num);
					}
				}
			}
		}
	}
	
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		nodeCount = sc.nextInt();
		edgeCount = sc.nextInt();
		queue = new PriorityQueue<Integer>();
		dist = new int[nodeCount + 1];
		nodeArray = new Node[nodeCount + 1];
		// nodeArray鍒濆嬪寲
		for (int i = 0; i < nodeCount + 1; i ++) {
			nodeArray[i] = new Node();
			dist[i] = max;
		}
		dist[1] = 0;
		
		for (int i = 0; i < edgeCount; i ++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			int edge = sc.nextInt();
			nodeArray[begin].addEdge(end, edge);
		}
		sc.close();
		
		long begin = System.currentTimeMillis();
		spfa();
		
		for (int i = 2; i < nodeCount + 1; i ++) {
			System.out.println(dist[i]);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - begin + "ms");
	}
}