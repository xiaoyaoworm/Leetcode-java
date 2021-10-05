class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if(graph == null || graph.length == 0) return null;
        int[] degree = new int[graph.length];
        Map<Integer, Set<Integer>> preNeighbors = new HashMap<Integer, Set<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i= 0; i < graph.length; i++){
            int[] destinations = graph[i];
            for(int dest: destinations){
                if(!preNeighbors.containsKey(dest)) preNeighbors.put(dest, new HashSet<Integer>());
                preNeighbors.get(dest).add(i);
                degree[i]++;// Be attention if no dependency is added, we want to add its prerequiste
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < graph.length; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.remove();
            res.add(cur);
            if(preNeighbors.containsKey(cur)){
                for(int pre: preNeighbors.get(cur)){
                    if(--degree[pre]==0){
                        queue.add(pre);
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}