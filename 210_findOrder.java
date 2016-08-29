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