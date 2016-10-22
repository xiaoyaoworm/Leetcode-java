public class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() < k) return 0;
        return dfs(s.toCharArray(), 0, s.length(), k); //BE careful this is s.length(), which is exclusive!!!
    }
    
    public int dfs(char[] arr, int start, int end, int k){
        if(start >= end) return 0;
        if(end - start < k) return 0;
        
        int[] count = new int[26];
        for(int i = start; i < end; i++){
            count[arr[i]-'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(count[i] == 0) continue;
            if(count[i] < k){ //This char should not belong to any substring. so remove it.
                char c = (char)(i+'a');
                for(int j = start; j < end; j++){
                    if(arr[j] == c){
                        int left = dfs(arr, start, j, k);  //j is exclusive
                        int right = dfs(arr, j+1, end, k); // end is exclusive
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }
}