这道题跟merge k sorted list是一类题目。

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Comparator<Tuple> comparator = new Comparator<Tuple>(){
            public int compare(Tuple a, Tuple b){
                return a.arr[a.start] - b.arr[b.start];
            }  
        };
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(n, comparator);
        for(int[] m: matrix){
            pq.offer(new Tuple(m, 0));
        }
        
        while(k > 0){
            Tuple current = pq.remove();
            k--;
            if(k == 0) return current.arr[current.start];
            if(current.start == current.arr.length-1) continue;
            else{
                current.start++;
                pq.offer(current);
            }
        }
        return -1;
    }
    
    public class Tuple{
        public int[] arr;
        public int start;
        
        public Tuple(int[] arr, int start){
            this.arr = arr;
            this.start = start;
        }
    }
}