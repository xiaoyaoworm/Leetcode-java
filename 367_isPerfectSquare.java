//O(logN)解法！
public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        int i = 1; //start from 1 not 0!!!
        int j = num;
        long mid = 0; //define as long will solve lots of overflow problems!!!! mid * mid may overflow!!!
        while(i <= j){
            mid = i+(j-i)/2;
            if(mid * mid == num) return true;
            else if(mid * mid < num) i = (int)mid+1; //dont forget (int) convert
            else j = (int)mid-1;
        }
        return false;
    }
}