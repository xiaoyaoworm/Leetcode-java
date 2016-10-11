public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //dp[i] means if current digit has length as i(first is not 0), how many unique number
        //first is not 0, so it can be 9, if first is 9, the second can be any 0~9 except the first, which is 8, 
        // next can be 7, then 6, then 5.
        //dp[0] = 1, dp[1] = 10, dp[2] = 9*9, dp[3] = 9*9*8, dp[4] = 9*9*8*7....dp[11] = 0(no unique)
        //if we want to count n, just accumulate all dp[i] for i <= 7
        if(n == 0)  return 1;
        int res = 10; //n = 1 can be 10.
        int uniqueDigits = 9; 
        int available = 9;
        while(n > 1 && available > 0){ // availalbe = 0, uniqueDigits(dp[i]) will become 0
            uniqueDigits = uniqueDigits * available; 
            res+= uniqueDigits;
            available --;
            n--;
        }
        return res;
    }
}