class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer sb = new StringBuffer();
        for(int i = S.length()-1; i>= 0; i--){
            if(S.charAt(i)!='-'){
                if(sb.length()%(K+1) == K) sb.append('-'); //be careful sb includes "-" so we should % k+1
                sb.append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}