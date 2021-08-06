class Solution {
    static int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0 || forest.get(0).size() == 0) return 0;
        int m = forest.size();
        int n = forest.get(0).size();

        //use PQ to save all sorted height tree info: first is x, second is y, third is height
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                int height = forest.get(i).get(j);
                if(height > 1) pq.offer(new int[]{i, j, height});
            }
        }

        int[] start = new int[2];
        int res = 0;
        while(!pq.isEmpty()){
            int[] target = pq.poll();
            int step = findStep(forest, start, target, m, n);
            if(step == -1) return -1; // cannot find path!
            res += step;
            //DO NOT FORGET SETTING NEW START POINT SAME AS TARGET
            start[0] = target[0];
            start[1] = target[1];
        }
        return res;
    }


    private int findStep(List<List<Integer>> forest, int[] start, int[] target, int m, int n){
        LinkedList<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        queue.add(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if(x == target[0] && y == target[1]) return step;
                for(int[] d: dir){
                    int newX = x+d[0];
                    int newY = y+d[1];
                    if(newX < 0 || newY < 0 || newX >= m || newY >= n 
                       ||forest.get(newX).get(newY) == 0 || visited[newX][newY]) continue; //do not forget check it is not 0!!!
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            step++;
        }
        return -1;
    }
}