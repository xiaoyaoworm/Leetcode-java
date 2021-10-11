class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(start);
        visited.add(start);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                Set<String> nextSet = oneDistance(cur, bank, visited);
                if(nextSet.contains(end)){
                    return level+1;
                }
                for(String str: nextSet){
                    queue.add(str);
                }
            }
            level++;
        }
        return -1;
    }
    
    public Set<String> oneDistance(String str, String[] bank, Set<String> visited){
        Set<String> set = new HashSet<String>();
        for(String word: bank){
            if(visited.contains(word)) continue;
            if(isOneDistance(str, word)){
                set.add(word);
                visited.add(word);
            }
        }
        return set;
    }
    
    public boolean isOneDistance(String str1, String str2){
        if(str1 == null || str2 == null) return false;
        if(str1.length() != str2.length()) return false;
        int diff = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i)!= str2.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}