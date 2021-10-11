class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();//Key is the stop, values is bus set
        if(source == target) return 0; //DO NOT FORGET
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                Set<Integer> buses = map.getOrDefault(routes[i][j], new HashSet<Integer>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }
        Set<Integer> visited = new HashSet<Integer>(); //visited Bus line
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                int cur = queue.remove();
                Set<Integer> buses = map.get(cur);
                for(int bus: buses){
                    if(visited.contains(bus)) continue;
                    visited.add(bus);
                    for(int j = 0; j < routes[bus].length; j++){ //Be attention this index is bus!!!!! not i!!!!
                        if(target == routes[bus][j]) return level;
                        queue.add(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}