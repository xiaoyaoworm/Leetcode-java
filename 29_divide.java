public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;
        
        long a = Math.abs((long)dividend); //long inside!!!
        long b = Math.abs((long)divisor);
        
        if(a == 0) return 0;
        if(a < b) return 0; // do it after abs
        
        long res = ldivide(a, b);
        if(res > Integer.MAX_VALUE){
            if(sign > 0) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE; 
        }
        return (int)(sign*res);
    }
    
    public long ldivide(long dividend, long divisor){
        if(dividend < divisor) return 0;
        long sum = divisor;
        long multiple = 1;
        while((sum+sum) < dividend){
            sum+=sum;
            multiple+=multiple;
        }
        return multiple + ldivide(dividend-sum, divisor);
    }
}