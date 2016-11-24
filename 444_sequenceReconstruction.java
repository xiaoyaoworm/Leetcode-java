public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(); //Using list, not hashSet!!
        //seq can be same: [1,2] and [1,2], if using set it will have problem.
        
        for(int[] seq: seqs){
            if(seq.length == 1){
                if(!degree.containsKey(seq[0])) degree.put(seq[0], 0);
                if(!graph.containsKey(seq[0])) graph.put(seq[0], new ArrayList<Integer>());
            } else{
                for(int i = 0; i < seq.length-1; i++){
                    int prev = seq[i];
                    int next = seq[i+1];
                    if(!degree.containsKey(prev)) degree.put(prev, 0);
                    if(!degree.containsKey(next)) degree.put(next, 0);
                    
                    degree.put(next, degree.get(next)+1); 
                    //this is get(next)+1!!! not get(prev), we don't know the gap between prev and next
                    
                    if(!graph.containsKey(prev)) graph.put(prev, new ArrayList<Integer>());
                    if(!graph.containsKey(next)) graph.put(next, new ArrayList<Integer>());
                    graph.get(prev).add(next);
                }
            }
        }
        
        if(degree.size()!= org.length) return false; //first check whether same integer numbers in org and seqs.
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int key: degree.keySet()){
            if(degree.get(key) == 0) queue.add(key);
        }
        
        int index = 0;//current org character pointer index
        while(!queue.isEmpty()){
            int size = queue.size();
            if(size > 1) return false; // one degree matches with two integer, which is not allowed.
            int temp = queue.remove();
            
            //if index is out of bound return false;
            //if org[index] is not equals to current temp, return false;
            if(index == org.length || org[index]!= temp) return false;
            
            index++;//dont forget!!!
            List<Integer> list = graph.get(temp);
            for(int next: list){
                degree.put(next, degree.get(next)-1);
                if(degree.get(next) == 0) queue.add(next);
            }
        }
        return index == org.length;
    }
}