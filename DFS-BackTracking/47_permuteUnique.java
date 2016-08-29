public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, 0, res);
        return res;
    }
    
    public void helper(int[] nums, int pos, List<List<Integer>> res){
        if(pos == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int n: nums) list.add(n);
            res.add(list);
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = pos; i < nums.length; i++){
            if(i!=pos && (nums[i] == nums[i-1] || set.contains(nums[i]))) continue;
            set.add(nums[i]);
            swap(nums, pos, i);
            helper(nums, pos+1, res);
            swap(nums, pos, i);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}