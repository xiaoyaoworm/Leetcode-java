/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        map.put(node,newNode);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.remove();
            List<UndirectedGraphNode> currentNeighbors = current.neighbors;
            
            for(UndirectedGraphNode currentNeighbor: currentNeighbors){
                if(map.containsKey(currentNeighbor)){
                    map.get(current).neighbors.add(map.get(currentNeighbor));
                } else{
                    UndirectedGraphNode copy = new UndirectedGraphNode(currentNeighbor.label);
                    map.put(currentNeighbor,copy);
                    queue.add(currentNeighbor);
                    map.get(current).neighbors.add(copy);
                }
            }
        }
        return newNode;
    }
}