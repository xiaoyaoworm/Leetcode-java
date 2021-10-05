public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(prerequisites == null) return res;
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < numCourses; i++){
            degree.put(i,0);
        }
        
        for(int[] p: prerequisites){
            int pre = p[1];
            int cur = p[0];
            HashSet<Integer> set = new HashSet<Integer>();
            if(map.containsKey(pre)) set = map.get(pre);
            if(!set.contains(cur)){
                set.add(cur);
                map.put(pre, set);
                degree.put(cur, degree.get(cur)+1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int n: degree.keySet()){
            if(degree.get(n) == 0) queue.add(n);
        }
        
        int i = 0;
        while(!queue.isEmpty()){
            int course = queue.remove();
            res[i] = course;
            i++;
            
            if(map.containsKey(course)){
                for(int next: map.get(course)){
                    degree.put(next, degree.get(next)-1);
                    if(degree.get(next) == 0) queue.add(next);
                }
            }
        }
        
        if(i != degree.size()) return new int[0];
        return res;
    }
}




//Using array instead of hashmap
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int next = prerequisites[i][0];
            if(matrix[pre][next] == 0){
                degree[next]++;
            }
            matrix[pre][next] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.remove();
            res.add(cur);
            for(int i = 0; i < numCourses; i++){
                if(matrix[cur][i] != 0){
                    if(--degree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        if (res.size() != numCourses) return new int[0];
        int[] resInt = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            resInt[i] = res.get(i);
        }
        return resInt;
    }
}