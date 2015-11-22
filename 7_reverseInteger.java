public class Solution {
    public int reverse(int x) {
        boolean isPositive = true;
        int result = 0;
        if(x < 0) {
            isPositive = false;
            x = -x;
        }
        while(x!=0){
            if(Math.abs(result)>Integer.MAX_VALUE/10) return 0; //Most Important thing
            result = result*10 +x%10;
            x = x/10;
        }
        if(!isPositive){
            result = -result;
        }
        return result;
    }
}