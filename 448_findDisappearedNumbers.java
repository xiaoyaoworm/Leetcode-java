public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            nums[index] = Math.abs(nums[index]) * (-1); //mark that index as negative if you see this number.
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) res.add(i+1);
        }
        return res;
    }
   
}