public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        result.add(new ArrayList<Integer>());
        
        Arrays.sort(nums);
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i]!= nums[i-1]) start = 0;
            int size = result.size();
            for(int j = start; j < size; j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            start = size;
        }
        return result;
    }
}