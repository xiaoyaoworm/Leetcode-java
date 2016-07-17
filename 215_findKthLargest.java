Quick Select解法：
算法复杂度：average -- O(n), worst -- O(n^2)

public class Solution {
    public int findKthLargest(int[] nums, int k) { 
        int n = nums.length;
        int index = partition(nums,0,n-1,n+1-k);
        return nums[index];
    }
    
    public int partition(int[] nums, int l, int r, int k){
        int pivot = nums[r];
        int storeIndex = l;
        for(int i = l; i < r; i++){
            if(nums[i]<= pivot){
                swap(nums,i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, storeIndex,r);
        int left = storeIndex+1-l;
        if(left == k) return storeIndex;
        else if(left < k) return partition(nums, storeIndex+1, r, k-left);
        else return partition(nums,l, storeIndex-1,k);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}




PQ解法,时间复杂度:构建整个的heap的PQ，用时是NlogN，插入操作是logN，但因为我们要插入N个点，所以O(NlogN)。
注意pq不加comparator实现的是MIN HEAP,所以升序解里面保证最小值都被踢掉了，最后pq里面剩下了k个值，peek的那个就是第k个最大值。


升序解：
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num: nums){
            pq.offer(num);
            while(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

降序解：
Collections.reverseOrder()是这个Comparator！！！可代替它！

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        Comparator<Integer> comparator = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, comparator);
        for(int num: nums){
            pq.offer(num);
        }
        while(k > 0){
            result = pq.poll();
            k--;
        }
        return result;
    }
}


