public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0) return false;
        if(num == 1) return true;
        if(num%4 != 0) return false;
        return isPowerOfFour(num/4);
    }
}

//解释如下： x^n - 1 = (x - 1)*(x^(n-1)+...+x+1);so x^n - 1 has a factor x - 1.here x = 4.
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        if((num&(num-1)) == 0 && (num-1)%3 == 0) return true; //First part is power of two, the second part is (num-1) % 3 == 0
        return false;
    }
}	

