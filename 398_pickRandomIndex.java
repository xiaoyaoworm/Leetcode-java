//Use some Math equation to do this!!!! AWESOME!!!
public class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int count = 0; // to record how many targets in the array
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=target) continue;

        //For the nth target, ++count is n. Then the probability that rnd.nextInt(++count)==0 is 1/n. 
        //Thus, the probability that return nth target is 1/n.
        //For (n-1)th target, the probability of returning it is (n-1)/n * 1/(n-1)= 1/n.
        //(n-1)/n is the last nth is not hitted. so the last two hit it like 1/(n-1).

            if(random.nextInt(++count) == 0){
                res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

//TLE解法，应该是因为题目里这一句note：The array size can be very large. Solution that uses too much extra space will not pass the judge.
public class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    Random random;

    public Solution(int[] nums) {
        map = new HashMap<Integer, ArrayList<Integer>>();
        random = new Random();
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(n)) list = map.get(n);
            list.add(i);
            map.put(n, list);
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        if(list == null) return -1;
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */