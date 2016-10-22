public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int k = 0;
        while(k+1 < nums.length && nums[k+1]== nums[k]) k++; //remove same number in the front situation
        if(k+1 == nums.length) return 1; // not 0
        
        int len = 2; //initial should including first characters, so it is 2.
        
        boolean increase = (nums[k] < nums[k+1]); //check first non-same is increase or not.
        int i = k+1;
        while(i+1 < nums.length){
            if(increase){ //Greedy algorithm
                if(nums[i+1] < nums[i]){
                    increase = !increase;
                    len++;
                }
            } else{
                if(nums[i+1] > nums[i]){
                    increase = !increase;
                    len++;
                }
            }
            i++; //all needs this.
        }
        return len;
    }
}