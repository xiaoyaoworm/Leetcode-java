public class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n: nums){
            if(set.contains(n)){
                set.remove(n);
            } else{
                set.add(n);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for(int n: set){
            result[i] = n;
            i++;
        }
        return result;
    }
}