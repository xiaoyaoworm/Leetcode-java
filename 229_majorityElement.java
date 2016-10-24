public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        
        int first = nums[0];
        int second = nums[0];
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == first){
                count1++;
            } else if(nums[i] == second){
                count2++;
            } else if(count1 == 0){
                first = nums[i];
                count1++;
            } else if(count2 == 0){
                second = nums[i];
                count2++;
            } else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == first) count1++;
            //here is else if!!! to get rid of both first and second are the same scenario
            else if(nums[i] == second) count2++; 
        }
        if(count1 > nums.length/3) res.add(first);
        if(count2 > nums.length/3) res.add(second);
        return res;
    }
}