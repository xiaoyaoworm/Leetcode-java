//优化解，时间复杂度O(N),空间复杂度O(1)
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) p1 = i;
            if(words[i].equals(word2)) p2 = i;
            if(p1!=-1 && p2!=-1){
                res = Math.min(res, Math.abs(p1-p2));//只需要检查相邻即可。不需要比较两个set的所有组合！！！注意那个俩都不等于-1！！！
            }
        }
        return res;
    }
}

//Naive 解法：Space is O(N), Time is O(n^2)
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) set1.add(i);
            if(words[i].equals(word2)) set2.add(i);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i: set1){
            for(int j: set2){
                res = Math.min(res, Math.abs(i-j));
            }
        }
        return res;
    }
}


