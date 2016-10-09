//O(N)解法，我们发现power of two都是一个bit，那么不是power of two的。
//我们可以把它拆分成当前他起始的这个power of two值和剩余值。相加即可。因为bit位一定不重叠。
public class Solution {
    public int[] countBits(int num) {
        int temp = 0; // use to save power of 2!
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            if(i == 0) res[i] = 0;
            else if((i&(i-1)) == 0){
                res[i] =  1;
                temp = i;
            }
            else res[i] = res[temp]+res[i-temp]; // use to calculate not power of 2. just split it.
        }
        return res;
    }
}


//Naive解法：算法复杂度：O(N*size of integer)
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            res[i] = count(i);
        }
        return res;
    }
    
    public int count(int num){
        int res = 0;
        while(num!=0){
            res+= (num&1);
            num = num >>>1;
        }
        return res;
    }
}