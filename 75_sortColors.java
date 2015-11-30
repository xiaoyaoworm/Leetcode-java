public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int i = 0;
        int j = nums.length-1;
        int k = 0;
        while(k<=j){
            if(nums[k] == 0){
                swap(nums,i,k);
                i++;
                k++; // must put k++ here, because left are all tested, k can move on.
            } else if(nums[k] == 2){
                swap(nums,k,j);
                j--;
            } else{
                k++;
            }
        }
    }
    
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}