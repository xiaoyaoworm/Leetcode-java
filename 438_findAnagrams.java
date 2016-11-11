public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;
        int[] hash = new int[256];
        
        for(char c: p.toCharArray()){
            hash[c]++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        while(right < s.length()){
            char r = s.charAt(right);
            if(hash[r] >= 1){
                count--;
            }
            hash[r]--;
            right++;
            
            if(count == 0) res.add(left);
            
            if(right-left == p.length()){
                char l = s.charAt(left);
                if(hash[l]>= 0){
                    count++;
                }
                hash[l]++;
                left++;
            }
            
        }
        return res;
        
    }
}