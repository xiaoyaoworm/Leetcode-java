class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (x, y) -> x.length()-y.length());
        int res = 0;
        for(String word: words){
            int current = 0;
            for(int i = 0; i < word.length(); ++i){
                String prev = word.substring(0, i) + word.substring(i+1);
                current = Math.max(current, map.getOrDefault(prev, 0)+1);
            }
            map.put(word, current);
            res = Math.max(res, current);
        }
        return res;
    }
}