package tajpure;

import java.util.HashMap;
import java.util.LinkedList;


public class CloneGraph {
	 public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node == null) return null;
	        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
	        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	        map.put(newNode.label, newNode);

	        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	        queue.add(node);

	        while (!queue.isEmpty()) {
	            UndirectedGraphNode n = queue.pop();
	            for (UndirectedGraphNode neighbor : n.neighbors) {
	                if (!map.containsKey(neighbor.label)) {
	                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
	                    queue.add(neighbor);
	                }
	                map.get(n.label).neighbors.add(map.get(neighbor.label));
	            }
	        }

	        return newNode;
	    }
	 
	 public static void main(String[] args) {
		 
	 }
}