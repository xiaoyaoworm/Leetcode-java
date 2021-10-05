class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][0];
            int next = prerequisites[i][1];
            if(matrix[pre][next] == 0){
                degree[next]++;
            }
            matrix[pre][next] = 1;
        }
        
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int cur = queue.remove();
            count++;
            for(int i = 0; i < numCourses; i++){
                if(matrix[cur][i] != 0){
                    if(--degree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}