class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(similarPairs == null || sentence1.length != sentence2.length) return false;
        
        UF uf = new UF(similarPairs.size());
        Map<String, Integer> wordToIndex = new HashMap<>();
        for(int i = 0; i < similarPairs.size(); i++){
            String first = similarPairs.get(i).get(0);
            String second = similarPairs.get(i).get(1);
            if(wordToIndex.containsKey(first)){
                uf.union(wordToIndex.get(first), i);                
            } else{
                wordToIndex.put(first, i);
            }
            if(wordToIndex.containsKey(second)){
                uf.union(wordToIndex.get(second), i);                
            } else{
                wordToIndex.put(second, i);
            }
        }
        
        for(int i = 0; i < sentence1.length; i++){
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if(word1.equals(word2)) continue; //Necessary!!!
            if(!wordToIndex.containsKey(word1) || !wordToIndex.containsKey(word2)) return false; //Necessary!!!
            int p = uf.find(wordToIndex.get(word1));
            int q = uf.find(wordToIndex.get(word2));
            if(p!=q) return false;
        }
        return true;
    }
    
    public class UF{
        int[] parents;
        int count;
        public UF(int n){
            this.count = n;
            this.parents = new int[n];
            for(int i = 0; i < n; i++){
                parents[i]=i;
            }
        }
        
        private void union(int x, int y){
            int p = find(x);
            int q = find(y);
            if(p == q) return;
            parents[p] = q;
            count--;
        }
        
        private int find(int x){
            while(parents[x]!=x){
                x = find(parents[x]);
            }
            return x;
        }
    }
}