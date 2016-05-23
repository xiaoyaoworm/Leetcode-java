/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        buildString(root,sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuffer sb){
        if(sb.length() != 0) sb.append(",");
        if(root == null) sb.append("null");
        else {
            sb.append(root.val);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<String>();
        String[] nodes = data.split(",");
        for(String node: nodes){
            list.add(node);
        }
        return buildTree(list);
    }
    
    private TreeNode buildTree(LinkedList<String> list){
        if(list == null) return null;
        String current = list.remove(0);
        if(current.equals("null")){
            return null;
        } else{
            int val = Integer.valueOf(current);
            TreeNode node = new TreeNode(val);
            node.left = buildTree(list);
            node.right = buildTree(list);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));