public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return result;
        
        for(int i = 0; i < nums.length; i++){
            int size = result.size(); //get size at first, because our result is updated in the for loop.
            for(int j = 0; j < size; j++){
                List<Integer> copy = new ArrayList<Integer>(result.get(j)); // use result.get(j) because even result is updated, but the first size list are still same
                copy.add(nums[i]);
                result.add(copy);
            }
        }
        return result;
    }
}