public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(nums,0,result);
        return result;
    }
    
    public void permuteHelper(int[] nums, int start, List<List<Integer>> result){
        if(start == nums.length) {
            result.add(toList(nums));
        }
        for(int i = start; i < nums.length;i++){
            swap(nums,i,start);
            permuteHelper(nums,start+1,result);
            swap(nums,i,start);
        }
    }
    
    public List<Integer> toList(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        for(int s: nums){
            result.add(s);
        }
        return result;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}