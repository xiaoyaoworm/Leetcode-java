public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length -2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int sum = 0- nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[j]+nums[k] == sum){
                    List<Integer> current = new LinkedList<Integer>();
                    current.add(nums[i]);
                    current.add(nums[j]);
                    current.add(nums[k]);
                    result.add(current);
                    while(j+1<k && nums[j] == nums[j+1]) j++;
                    while(j<k-1 && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if (nums[j]+nums[k] > sum){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}