public class Solution {
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n: nums){
            if(!set.contains(n)){
                pq.offer(n);
                set.add(n);
                if(pq.size() > 3) pq.poll();
            }
        }
        if(pq.size() == 3) return pq.poll();
        while(pq.size() != 1){
            pq.poll();
        }
        return pq.poll();
    }
}