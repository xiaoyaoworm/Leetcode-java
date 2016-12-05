public class Solution {
    int[] dx = new int[]{0,1,0,-1};
    int[] dy = new int[]{1,0,-1,0};

    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];
        Comparator<Node> comparator = new Comparator<Node>(){
            public int compare(Node a, Node b){
                return a.h - b.h;
            }    
        };
        Queue<Node> queue = new PriorityQueue<Node>(comparator);
        for(int i = 0; i < m; i++){
            queue.offer(new Node(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            queue.offer(new Node(i, n-1, heightMap[i][n-1]));
            visited[i][n-1] = true;
        }
        for(int j = 1; j < n-1; j++){
            queue.offer(new Node(0, j, heightMap[0][j]));
            visited[0][j] = true;
            queue.offer(new Node(m-1, j, heightMap[m-1][j]));
            visited[m-1][j] = true;
        }
        
        int res = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int x = node.i+dx[dir];
                int y = node.j+dy[dir];
                if(x >= 0 && y >= 0 && x < m && y <n && !visited[x][y]){
                    queue.offer(new Node(x, y, Math.max(heightMap[x][y], node.h))); //here is Math.max!!
                    visited[x][y] = true;
                    res+= Math.max(0, node.h-heightMap[x][y]);
                }
            }
        }
        return res;
    }
    
    public class Node{
        int i;
        int j;
        int h;
        public Node(int i, int j, int h){
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }
}