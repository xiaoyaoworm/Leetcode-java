public class Solution {
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,1,0,-1};
    
    //start from all building, use dist to save this node's dists from all buildngs.
    //check the sum of it, find min
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dist = new int[m][n];
        List<Node> buildings = new ArrayList<Node>();

        //there are count number of building
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    buildings.add(new Node(i, j, 0));
                }
                grid[i][j] = -grid[i][j];// if not 0, change it to negative, so that adding together will not be dist.size()
            }
        }
        
        //BFS from every building
        for(int k = 0; k < buildings.size(); k++){
            bfs(buildings.get(k), k, dist, grid);
        }

        int res = -1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == buildings.size() && (res < 0 || dist[i][j] < res)){
                    res = dist[i][j];
                }
            }
        }
        return res;
        
    }
    
    public void bfs(Node root, int k, int[][] dist, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            dist[node.i][node.j] += node.dist;
            for(int i = 0; i < 4; i++){
                int x = node.i+dx[i];
                int y = node.j+dy[i];
                if(x>=0 && y>=0&& x< m && y < n && grid[x][y] == k){//everytime reaching here will add one, so here is k.
                    grid[x][y] = k+1;
                    queue.add(new Node(x, y, node.dist +1));
                }
            }
        }
    }



    public class Node{
        int i;
        int j;
        int dist;

        public Node(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

}