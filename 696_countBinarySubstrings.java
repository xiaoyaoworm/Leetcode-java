class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() <= 1) return 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            } else{
                list.add(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        list.add(count);
        
        for(int i = 1; i < list.size(); i++){
            res += Math.min(list.get(i), list.get(i-1));
        }
        return res;
    }
}


//O(1)
class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() <= 1) return 0;
        int res = 0;
        int prev = 0; 
        int cur = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cur++;
            } else{
                res+= Math.min(cur,prev);
                prev = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, prev); //Do not forget the last cur!!!!
    }
}