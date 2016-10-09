//稍微做个数学题。n is the A.length
//pre =            0A[0] + 1A[1] +2A[2] +.....(n-2)A[n-2] + (n-1)A[n-1]; 
//cur = 0A[n-1] +  1A[0] + 2A[1] +3A[2] +.....(n-1)A[n-2]     
//cur-pre = AllSum - nA[n-1]; 
//We can consider all scenario: 
//cur-pre = AllSum - A.length * A[pre.lastIndex]
//cur = pre+AllSum -A.length * A[pre.lastIndex]
//if we get the first one and allSum, we can get everything. this is O(N) solution.

public class Solution {
    public int maxRotateFunction(int[] A) {
        int allSum = 0;
        int last = 0;
        for(int i = 0; i < A.length; i++){
            last += A[i]*i;
            allSum+=A[i];
        }
        
        int res = last; 
        for(int i = A.length-1; i >= 1; i--){
            last += allSum-A.length*A[i]; 
            //cur should be calculated based on last
            res = Math.max(res, last);
            // we are updating res based on MAX
        }
        return res;
    }
}


//TLE 时间复杂度O(n^2)
public class Solution {
    public int maxRotateFunction(int[] A) {
        int res = Integer.MIN_VALUE;
        if(A == null || A.length == 0) return 0;
        for(int i = 0; i < A.length; i++){
            res = Math.max(res, calculate(A, i));
        }
        return res;
    }
    
    public int calculate(int[] A, int index){
        int res = 0;
        for(int i = index; i < A.length+index; i++){
            res+= A[i%A.length] * (i-index);
        }
        return res;
    }
}