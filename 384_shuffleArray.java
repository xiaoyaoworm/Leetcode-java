//copy 一个数组可以用clone()!!!
//principle is swap : for loop: i = 1~len-1 with j=random.nextInt(i+1)

public class Solution {
    int[] original;
    Random random;

    public Solution(int[] nums) {
        this.original = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(original == null) return null;
        int[] copy = original.clone(); //Attention 1: you can use arr.clone() to make a clone!!!!
        for(int i = 1; i < copy.length; i++){ //Principle is here, i can be 1~copy.length()-1
            int j = random.nextInt(i+1); //j can be any number between 0~i(including)
            swap(copy, i, j); //swap them in for loop.
        }
        return copy;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

//TLE解法，有个问题就是，我是initial的时候，把所有的permutations都列出来了。
//其实并不需要
public class Solution {
    int[] original;
    List<int[]> permutations;

    public Solution(int[] nums) {
        this.original = nums;
        this.permutations = new ArrayList<int[]>();
        dfs(nums, permutations, 0);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int i = random.nextInt(permutations.size());
        return permutations.get(i);
    }
    
    public void dfs(int[] nums, List<int[]> permutations, int pos){
        if(pos == nums.length){
            int[] copy = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                copy[i] = nums[i];
            }
            permutations.add(copy);
            return;
        }
        
        for(int i = pos; i < nums.length; i++){
            swap(nums, pos, i);
            dfs(nums, permutations, i+1);
            swap(nums, i, pos);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */