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
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(run.children[index] == null){
                run.children[index] = new TrieNode();
            }
            run = run.children[index];
        }
        run.isWord = true;
    }
 
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null) return false;
        return dfs(root,word,0);
    }
     
     
    public boolean dfs(TrieNode root, String word, int index){
        if(root.isWord && index == word.length()){
            return true;
        }
        if(index >= word.length()){
            return false;
        }
        char c = word.charAt(index);
        if(c == '.'){
            boolean res = false;
            for(int i = 0; i < 26; i++){
                if(root.children[i]!=null){
                    if(dfs(root.children[i],word,index+1)){
                        res = true;
                        break;
                    }
                }
            }
            if(res) return true;
        } else{
            if(root.children[c-'a']==null) return false;
            else {
                return dfs(root.children[c-'a'],word,index+1);
            }
        }
        return false;
    }
}
 
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");