public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n%2 != 0) return false;
        return isPowerOfTwo(n/2);   
    }
}

//If this is power of two, n means bit num: the first one is 1 the rest are 0
// so (n-1) = the first one is 0, the rest are 1
// (n&(n-1)) should equals to 0.(all 0)
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1)) == 0;
    }
}