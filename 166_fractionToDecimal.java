public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        if((numerator > 0 && denominator <0) || (numerator < 0 && denominator >0))sb.append("-");
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        sb.append(num/den);
        if(num%den == 0) return sb.toString();
        
        sb.append("."); // dont forget!!!
        
        num %= den;
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, sb.length());
        while(num!=0){
            num*=10; //dont forget!!!
            sb.append(num/den);
            num%=den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                return sb.toString();
            } else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}