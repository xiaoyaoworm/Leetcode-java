public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return result;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(map.containsKey(key)) map.get(key).add(str);
            else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key,list);
            }
        }
        for(String k: map.keySet()){
            result.add(map.get(k));
        }
        return result;
    }
}