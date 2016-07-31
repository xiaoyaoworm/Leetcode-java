public class WordDictionary {

    public class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode(){
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public WordDictionary(){
        this.root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode run = root;
        for(char c: word.toCharArray()){
            int i = c-'a';
            if(run.children[i] == null) run.children[i] = new TrieNode();
            run = run.children[i];
        }
        run.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    
    public boolean dfs(String word, TrieNode node, int start){
        if(start == word.length() && node.isWord) return true;
        if(start >= word.length()) return false;
        
        char c = word.charAt(start);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    if(dfs(word, node.children[i], start+1)) return true;
                }
            }
            return false;
        } else{
            if(node.children[c-'a'] == null) return false;
            else return dfs(word, node.children[c-'a'],start+1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");