package july_10;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int x) { 
		label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
	public static UndirectedGraphNode gererateGraph(String str){
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(0, node);
		node.neighbors.add(1, node);
		return node;
	}
	

}
