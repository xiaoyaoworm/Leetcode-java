public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        helper(s, 0, res, list);
        return res;
    }
    
    public void helper(String s, int pos, List<List<String>> res, List<String> list){
        if(pos == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            String first = s.substring(pos, i+1);
            if(isPalindrome(first)){
                list.add(first);
                helper(s, i+1, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        if(str == null) return false;
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}