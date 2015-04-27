//http://xiaoyaoworm.com/blog/2015/04/15/%E6%96%B0leetcode-hashtable-4-single-number/

public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++){
            result^=A[i];  
        }
        return result;
    }
}