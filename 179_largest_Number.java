//http://xiaoyaoworm.com/blog/2015/04/08/%E6%96%B0leetcode-sort-5-largest-number/


public class Solution {
    public String largestNumber(int[] num) {
        String[] numStr = new String[num.length];
        for(int i = 0; i < num.length; i++){
            numStr[i] = String.valueOf(num[i]);
        }
         
        Comparator<String> comparator = new Comparator<String>(){
            public int compare(String x, String y){
                String leftRight = x.concat(y);
                String rightLeft = y.concat(x);
                return rightLeft.compareTo(leftRight);
            }
        };
         
        Arrays.sort(numStr, comparator);
         
        StringBuffer sb = new StringBuffer();
        for(String n: numStr){
            sb.append(n);
        }
         
        java.math.BigInteger result = new java.math.BigInteger(sb.toString());
        return result.toString();
    }
}