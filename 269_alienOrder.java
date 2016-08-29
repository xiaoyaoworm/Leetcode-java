public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        
        HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        HashMap<Character, Integer> degree = new HashMap<Character, Integer>();
        
        for(String word: words){
            for(char c: word.toCharArray()){
                if(!degree.containsKey(c)) degree.put(c,0);
            }
        }
        
        for(int i = 0; i < words.length-1; i++){
            String cur = words[i];
            String next = words[i+1];
            
            int len = Math.min(cur.length(), next.length());
            for(int j = 0; j < len; j++){
                char c = cur.charAt(j);
                char n = next.charAt(j);
                
                if(c!=n){
                    HashSet<Character> set = new HashSet<Character>();
                    if(map.containsKey(c)) set = map.get(c);
                    if(!set.contains(n)){
                        set.add(n);
                        map.put(c,set);
                        degree.put(n, degree.get(n)+1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c) == 0) queue.add(c);
        }
        
        StringBuffer res = new StringBuffer();
        while(!queue.isEmpty()){
            char c = queue.remove();
            res.append(c);
            if(map.containsKey(c)){
                for(char n: map.get(c)){
                    degree.put(n, degree.get(n)-1);
                    if(degree.get(n) == 0) queue.add(n);
                }
            }
        }
        
        if(res.length() != degree.size()) return "";
        else return res.toString();
    }   
}