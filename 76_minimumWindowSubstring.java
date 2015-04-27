//http://xiaoyaoworm.com/blog/2015/04/19/%E6%96%B0leetcode-hashtable-7-minimum-window-substring/

public class Solution {
    public String minWindow(String S, String T) {
        String result = "";
        if(S == null || T == null || S.length() == 0 || T.length() == 0) return result;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(char c: T.toCharArray()){
            if(dict.containsKey(c)){
                dict.put(c,dict.get(c)+1);
            } else{
                dict.put(c,1);
            }
        }
         
        int count = 0;
        int pre = 0;
        int minLen = S.length()+1;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(dict.containsKey(c)){
                dict.put(c,dict.get(c)-1);
                if(dict.get(c)>=0){ // including equal scenario
                    count++;
                }
                 
                while(count == T.length()){
                    char p = S.charAt(pre);
                    if(dict.containsKey(p)){
                        dict.put(p,dict.get(p)+1);
                        if(dict.get(p)>0){
                            if(minLen > i+1-pre){
                                minLen = i+1-pre;
                                result = S.substring(pre, i+1);
                            }
                            count--;
                        }
                    }
                    pre++;
                }
            }
        }
        return result;
    }
}