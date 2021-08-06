/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        List<Integer> list = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int current = 1;
        int next = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.val);
            current--;
            
            for(Node child: node.children){
                queue.add(child);
                next++;
            }
            if(current == 0){
                res.add(list);
                list = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        return res;
    }
}