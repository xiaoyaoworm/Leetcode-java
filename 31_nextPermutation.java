public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length -1;
        while(i>=1){
            if(nums[i-1] < nums[i]){
                break; // find i-1
            }
            i--;
        }
        
        if(i == 0){ //54321
            swap(nums, 0, nums.length-1);  //12345
        } else{
            int j = nums.length-1;
            while(j > i-1){
                if(nums[j] > nums[i-1]){
                    int temp = nums[j];
                    nums[j] = nums[i-1];
                    nums[i-1] = temp;
                    break;
                }
                j--;
            }
            swap(nums, i, nums.length-1);
        }
    }
    
    
    public void swap(int[] nums, int start, int end){
        while(start< end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}