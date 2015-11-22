public class Solution {
    public String intToRoman(int num) {
        String[] symbol= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < symbol.length;i++){
            while(num>=value[i]){
                num-=value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}