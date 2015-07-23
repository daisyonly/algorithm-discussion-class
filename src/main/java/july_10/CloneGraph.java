package july_10;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map= new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode newNode=cloneGraph(node,map);
		
		return newNode;
	        
	}

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		// TODO Auto-generated method stub
		if(node==null) return null;
		if(map.containsKey(node)){
			return map.get(node);
		}
		UndirectedGraphNode newNode= new UndirectedGraphNode(node.label);
		if(map.containsKey(node)==false){			
			map.put(node, newNode);
			System.out.println(node.neighbors.size());
			for(int i=0;i<node.neighbors.size();i++){
				newNode.neighbors.add(i, cloneGraph(node.neighbors.get(i), map));
			}
		}
		return newNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node = UndirectedGraphNode.gererateGraph("");
		System.out.println(node.neighbors.size());
		CloneGraph a= new CloneGraph();
		a.cloneGraph(node);

	}

}
