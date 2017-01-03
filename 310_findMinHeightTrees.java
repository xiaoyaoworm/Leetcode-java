//O(N)解法，我们发现这个点要么是1个要么是两个，类似于找中数的概念。先找到叶节点 然后从叶节点往中间走。一次所有点往内走一步，最终如果剩下不超过两个点，那就是找到了。
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){ //dont forget, while condition is n > 2
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        List<Set<Integer>> connection = new ArrayList<Set<Integer>>(n); //dont forget init this n as size
        for(int i = 0; i < n; i++) connection.add(new HashSet<Integer>());
        
        for(int[] edge: edges){
            connection.get(edge[0]).add(edge[1]);
            connection.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(connection.get(i).size() == 1) leaves.add(i);
        }
        
        while(n > 2){ //when n == 1 or 2, meaning we find all. The result can only be 1 or 2.
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();
            for(int leave: leaves){
                int node = connection.get(leave).iterator().next();
                connection.get(node).remove(leave);
                if(connection.get(node).size() == 1) newLeaves.add(node);
            }
            n-=leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
}