//Ref: https://discuss.leetcode.com/topic/43055/why-factor-2-or-3-the-math-behind-this-problem/9
//Smart Explanation why we don't need 4 or more than 4 as factor:
//If an optimal product contains a factor f >= 4, then you can replace it with factors 2 and f-2 without losing optimality, as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4, meaning you only need factors 1, 2 and 3 (and 1 is of course wasteful and you'd only use it for n=2 and n=3, where it's needed).3*3 is simply better than 2*2*2, so you'd never use 2 more than twice.



public class Solution {
    public int integerBreak(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4; // 2*2, at most we should have two 2, because if we have three 2, it is less than 3*3
        int product = 1;
        while(n > 4){
            product *= 3;
            n-=3;
        }
        product *= n; // the left can be 1 or 2 or 3
        return product;
    }
}