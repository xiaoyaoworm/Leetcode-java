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
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node,newNode);
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.remove();
            List<UndirectedGraphNode> curNeighbors = cur.neighbors;
            for(UndirectedGraphNode aNeighbor: curNeighbors){
                if(map.containsKey(aNeighbor)){
                    map.get(cur).neighbors.add(map.get(aNeighbor));
                } else{
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copy);
                    queue.add(aNeighbor);
                    map.get(cur).neighbors.add(copy);
                }
            }
        }
        return newNode;
        
    }
}