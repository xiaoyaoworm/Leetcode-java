
class Solution {
    // Union find: https://leetcode.com/problems/similar-string-groups/discuss/132318/Simple-Java-Solution-using-DFS
    // Comment3(Voted most)
    public int numSimilarGroups(String[] strs) {
        if(strs== null) return 0;
        if(strs.length < 2) return strs.length;
        int[] parent = new int[strs.length];
        for(int i = 0 ; i < strs.length; i++) parent[i] = i;
        for(int i = 0; i < strs.length-1; i++){
            for(int j = i+1; j < strs.length; j++){
                if(isSimilar(strs[i], strs[j])){
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if(p1 != p2){
                        parent[p1] = p2;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0;  i< strs.length; i++){
            if(parent[i] == i) res++;
        }
        return res;
    }
    
    
    //This is because 'All words in strs have the same length and are anagrams of each other.''
    public boolean isSimilar(String s1, String s2){
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
        }
        return diff == 0 || diff == 2;
    }
    
    private int find(int[] parent, int x){
        while(parent[x]!=x){
            x = find(parent, parent[x]);
        }
        return x;
    }
}