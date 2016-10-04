//Naive解法。
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p = -1;
        int q = -1;
        int res = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    p = q;
                    q = i;
                    if(p!=-1 && q!=-1){
                        res = Math.min(res, q-p);
                    }
                }
            }
        } else{
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    p = i;
                }
                if(words[i].equals(word2)){
                    q = i;
                }
                if(p!=-1 && q!=-1){
                    res = Math.min(res, Math.abs(p-q));
                }
            }
        }
        return res;
    }
}