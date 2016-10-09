//O(N) space解法。

public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        int[] same = new int[n];
        int[] diff = new int[n];
        same[0] = k; //same[i] means current is same as previous one
        same[1] = k; 
        diff[0] = k; //diff[i] means current is different from previous one
        diff[1] = k*(k-1);
        for(int i = 2; i < n; i++){
            same[i] = diff[i-1]; // same can only be last one is different
            diff[i] = (k-1) * same[i-1] + (k-1)*diff[i-1]; // different can be adding last one same and last one diff
        }
        return same[n-1]+diff[n-1];
    }
}

//优化成O(1)解法. Attention same is 0!!!!! in the initial!!!!
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        int same = 0; // This is 0!!!!!!!!!!!
        int diff = k; 
        for(int i = 1; i < n; i++){
            int preSame = same;
            int preDiff = diff;
            same = preDiff; // same can only be last one is different
            diff = (k-1) * preSame + (k-1)*preDiff; // different can be adding last one same and last one diff
        }
        return same+diff;
    }
}