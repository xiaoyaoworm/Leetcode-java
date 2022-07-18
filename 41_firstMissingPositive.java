class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean[] arr = new boolean[length+1];//starting from 0
        for(int num: nums){
            if(num <=0 || num > length) continue;
            arr[num] = true;                
        }
        
        for(int i = 1; i <= length; i++){
            if(!arr[i]) return i;
        }
        return length+1;//If not return anything, then it is 1 to n, return n+1
    }
}