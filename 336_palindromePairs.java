public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length < 2) return res;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){// be careful here is <=, so that it can be ""
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)){
                    String str2rev = new StringBuffer(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev)!=i){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(isPalindrome(str2)){
                    String str1rev = new StringBuffer(str1).reverse().toString();
                    //dont forget to check str2.length()!=0 to get rid of duplicate!!! 
                    //For example, abcd,dcba, if withouth this it may return [0,1],[1,0],[1,0],[0,1]
                    if(map.containsKey(str1rev) && map.get(str1rev)!=i && str2.length()!= 0){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rev));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String str){
        if(str == null || str.length() == 0) return true;
        int i = 0;
        int j = str.length()-1;
        while(i < j){
            if(str.charAt(i)!= str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}