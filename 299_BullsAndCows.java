public class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null && guess == null) return "";
        boolean[] flag = new boolean[secret.length()];
        
        int bull = 0;
        int cow = 0;
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c: secret.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }
        
        for(int i = 0; i < secret.length(); i++){
            char m = secret.charAt(i);
            char n = guess.charAt(i);
            if(m == n) {
                flag[i] = true;
                map.put(m,map.get(m)-1);
                bull++;
            }
        }
        
        for(int j = 0; j < secret.length(); j++){
            char n = guess.charAt(j);
            if(!flag[j] && map.containsKey(n) && map.get(n)>=1){
                cow++;
                map.put(n,map.get(n)-1);
            }
        }
        StringBuffer sb = new StringBuffer();
        return sb.append(bull).append("A").append(cow).append("B").toString();
    }
}