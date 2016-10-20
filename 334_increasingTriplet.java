public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE; //Both set as MAX_VALUE
        for(int n: nums){
            if(n <= small) small = n; //update small when n is smaller than small and big both
            else if(n <= big) big = n; // update big only if n is smaller than big but larger than small
            else return true; //find a number which is bigger than both small and big.
        }
        return false;
    }
}