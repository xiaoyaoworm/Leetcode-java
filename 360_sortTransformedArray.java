public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null) return null;
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;
        
        int i = 0;
        int j = nums.length-1;
        int index = (a >= 0) ? j:i;
        while(i <= j){
            int l = calculate(nums[i], a,b,c);
            int r = calculate(nums[j], a,b,c);
            if(a >= 0){
                if(l <= r) {
                    res[index] = r;
                    j--;
                }
                else {
                    res[index] = l;
                    i++;
                }
                index--;
            } else{
                if(l <= r){
                    res[index] = l;
                    i++;
                } else{
                    res[index] = r;
                    j--;
                }
                index++;
            }
        }
        return res;
    }
    
    public int calculate(int x, int a, int b, int c){
        return a*x*x+b*x+c;
    }
}