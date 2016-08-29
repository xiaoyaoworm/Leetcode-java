public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, res);
        return res;
    }
    
    public void helper(int[] nums, int pos, List<List<Integer>> res){
        if(pos == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int n: nums) list.add(n);
            res.add(list);
        }
        
        for(int i = pos; i < nums.length; i++){
            swap(nums, i, pos);
            helper(nums, pos+1, res);
            swap(nums, i, pos);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
