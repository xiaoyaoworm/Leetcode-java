public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        
        for(int[] b: buildings){
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]) return a[0]-b[0];
                else return a[1]-b[1];
            }
        };
        
        Collections.sort(height, comparator);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for(int[] h: height){
            if(h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]);
            int cur = pq.peek();
            if(prev != cur){
                result.add(new int[]{h[0],cur});
                prev = cur;
            }
        }
        return result;
    }
}