class Solution {
    int covered = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        return covered ==n;
    }
    
    public void dfs(List<List<Integer>> rooms, int current, boolean[] visited){
        if(visited[current]) return;
        visited[current] = true; //Visited only happens when entering this room
        covered++;
        List<Integer> key = rooms.get(current);
        for(int k: key){
            dfs(rooms, k, visited);
        }
    }
}