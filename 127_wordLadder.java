"The idea behind bidirectional search is to run two simultaneous searches—one forward from
the initial state and the other backward from the goal—hoping that the two searches meet in
the middle. The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth. "

----- section 3.4.6 in Artificial Intelligence - A modern approach by Stuart Russel and Peter Norvig


public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> startSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        startSet.add(beginWord);
        endSet.add(endWord);
        
        int minLen = 1;
        HashSet<String> visited = new HashSet<String>();
        
        while(!startSet.isEmpty() && !endSet.isEmpty()){
            if(startSet.size() > endSet.size()){
                HashSet<String> set = startSet;
                startSet = endSet;
                endSet = set;
            }
            
            HashSet<String> temp = new HashSet<String>();
            for(String cur: startSet){
                char[] arr = cur.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char old = arr[i];
                    for(char c= 'a'; c <= 'z'; c++){
                        if(c == old) continue;
                        arr[i] = c;
                        String newStr = new String(arr);
                        
                        if(endSet.contains(newStr)){
                            return minLen+1;
                        }
                        
                        if(!visited.contains(newStr) && wordList.contains(newStr)){
                            visited.add(newStr);
                            temp.add(newStr);
                        }
                        arr[i] = old;
                    }
                }
            }
            startSet = temp;
            minLen++;
        }
        return 0;
    }
}