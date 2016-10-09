//Ref: https://discuss.leetcode.com/topic/59314/java-solution
// find the length of the number where the nth digit is from
// find the actual number where the nth digit is from
// find the nth digit and return

public class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;//use long!!!
        int start = 1;
        
        while(n > len * count){
            n-=len*count;
            len++;
            count*=10;
            start*=10;
        }
        
        int num = start+ (n-1)/len; // everything starts from 0!!! so please minus one
        char c = String.valueOf(num).charAt((n-1)%len);
        return c-'0';
    }
}