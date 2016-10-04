//优化一下shortest，因为都是sorted的组合，所以merge以下，找不同，O(m+n)
public class WordDistance {
    HashMap<String, ArrayList<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(word)){
                list = map.get(word);
            }
            list.add(i);
            map.put(word, list);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ){ // pay attention to the condition here!!!!
            int first = list1.get(i);
            int second = list2.get(j);
            if(first < second){
                res = Math.min(res, second-first);
                i++;
            }
            else if(first > second){
                res = Math.min(res, first-second);
                j++;
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");


//Naive解法。 shortest的复杂度是O(m*n)
public class WordDistance {
    HashMap<String, ArrayList<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(word)){
                list = map.get(word);
            }
            list.add(i);
            map.put(word, list);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i: list1){
            for(int j : list2){
                res = Math.min(res, Math.abs(i-j));
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");