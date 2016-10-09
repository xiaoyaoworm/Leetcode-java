public class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        
        char[] arr= new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        
        String res = "";
        while(num!=0){
            res = arr[num&15] + res; //only leave last 4bytes,15 is all 1.
            //Must add in front of the whole list, because it is in the high part. res = XXX + res!!!!
            num = (num >>> 4); //shift right 4 bytes. >>> n is shift right n bytes!!! all shift needs ()
        }
        return res;
    }
}