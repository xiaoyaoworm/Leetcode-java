//See it from here: https://discuss.leetcode.com/topic/12133/bit-operation-solution-java/8

// last bit of (odd number & even number) is 0.
// when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
// Move m and n rigth a position.
// Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.

//m<<step means make it left several and put 0 after it.

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while(m!=n){
            m >>= 1; // dont forget that =
            n >>= 1;
            step++;
        }
        return m<<step;
    }
}


//https://leetcode.com/problems/bitwise-and-of-numbers-range/solution/
//This question is asking what is the common prefix for all those numbers in the range -> common prefix for two boundries.
//Use shift right to find common prefix, shen shift it back.