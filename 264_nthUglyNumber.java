//写出来的代码跟313完全一样，只是定义好了primes = new int[]{2,3,5}.详情请看313_nthSuperUglyNumber.java
public class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = new int[]{2,3,5};
        int[] res = new int[n];
        res[0] = 1;
        
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }    
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comparator);
        
        for(int i = 0; i < primes.length; i++){
            pq.offer(new int[]{primes[i], 0, primes[i]});
        }
        
        for(int i = 1; i < n; i++){
            int next = pq.peek()[0];
            res[i] = next;
            while(pq.peek()[0] == next){
                int[] current = pq.poll();
                current[0] = current[2]*res[current[1]];
                current[1] +=1;
                pq.offer(current);
            }
        }
        return res[n-1];
    }
}