public class Solution {
    public String getPermutation(int n, int k) {
        int[] factor = new int[n+1];
        factor[0] = 1;
        for(int i = 1; i <= n; i++){
            factor[i] = factor[i-1]*i;
        }
        
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        
        k--; // change 1-index to 0-index
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n; i++){
            int index = k/factor[n-i];
            sb.append(nums.get(index)); //pay attention, here is using the nums.get due to some are removed there.
            nums.remove(index); //this is O(n) in ArrayList, so total is O(n^2)
            k-=index*factor[n-i];
        }
        return sb.toString();
    } 
}