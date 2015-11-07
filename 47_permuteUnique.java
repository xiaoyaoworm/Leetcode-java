public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int k = nums.length;
        dfs(nums,0,k,result);
        return result;
    }
    
    public void dfs(int[] nums,int i, int k, List<List<Integer>> result){
        if(i == k){
            result.add(toList(nums));
        }
        for(int j = i; j < k; j++){
            if(checkNoDuplicate(nums,i,j)){ // Most Important condition to check, if there are no duplicate
                swap(nums,i,j);
                dfs(nums,i+1,k,result);
                swap(nums,i,j);
            }
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
    
    public boolean checkNoDuplicate(int[] nums, int i, int j){
        for(int start = i; start< j; start++){
            if(nums[start] == nums[j]){
                return false;
            }
        }
        return true;
    }
}