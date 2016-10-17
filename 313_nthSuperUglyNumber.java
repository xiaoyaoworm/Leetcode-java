//Time complexity is Nlog(M), M is primes.length
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || primes.length == 0 || n <= 0) return 0;
        int[] res = new int[n];
        res[0] = 1; //dont forget.
        
        //Three index in this int[]
        //first is current value, which will be the result
        //second is next res index it will multiple with
        //third is what is the base prime it origins
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0]; //based on value to sort, ASC
            }  
        };
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(primes.length, comparator);
        for(int p: primes){
            heap.add(new int[]{p,0,p}); //initial mid should be 0!
        }
        
        for(int i = 1; i < n; i++){
            int next = heap.peek()[0];
            res[i] = next;
            //here is while loop, if finding this heap still holds its value, for example, 202 and 303 can become 632 and 623
            //we know it is 6 now, we get the res[5] = 6 but we still need to move on to change 632 to 842, 623 to 933
            while(heap.peek()[0] == next){ 
                int[] cur = heap.poll();
                cur[0] = cur[2] * res[cur[1]]; //value will be base * res[current index]
                cur[1] = cur[1]+1; //current index keep ++
                heap.offer(cur); //put back into heap!!!
            }
        }
        
        
        return res[n-1]; //it is n-1
    }
}