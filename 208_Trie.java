class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    // Initialize your data structure here.
    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode run = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(run.children[index] == null) {
                run.children[index] = new TrieNode();
            }
            run = run.children[index];
        }
        run.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode find = endNode(word);
        return find!=null && find.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode find = endNode(prefix);
        return find!=null;
    }
    
    private TrieNode endNode(String word){
        TrieNode run = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(run.children[index] == null) return null;
            run = run.children[index];
        }
        return run;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");