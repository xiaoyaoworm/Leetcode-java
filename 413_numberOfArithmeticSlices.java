public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length<= 2) return 0;
        int current = 0;
        int sum = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                current++; 
                // current is when A[i-1] is the end, how many arithmeticSlice there.
                // here current++ is getting A[i] as end from current as A[i-1]
                sum+=current; // Adding all A[i-1] and its before sum.
            } else{
                current = 0; //reset current is 0;
            }
        }
        return sum;
    }
}