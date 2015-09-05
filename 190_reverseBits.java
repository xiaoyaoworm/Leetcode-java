public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = n & 1;
        for(int i = 1; i <=31; i++){
            n = n >> 1;
            res = res << 1;
            res = res | (n&1);
        }
        return res;
    }
}