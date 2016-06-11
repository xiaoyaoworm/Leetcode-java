public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord); // wordList may not have endWord! we need to add it because we pop to see whether it is there.
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 1)); // the beginWord is counted as 1
        
        while(!queue.isEmpty()){
            Node tempNode = queue.remove();
            String tempString = tempNode.word;
            int tempPath = tempNode.path;
            
            if(tempString.equals(endWord)) return tempPath;
            
            
            for(int i = 0; i < tempString.length(); i++){
                char[] tempChars = tempString.toCharArray();
                char temp = tempChars[i];
                for(char c = 'a'; c<='z';c++){
                    if(temp == c) continue;
                    tempChars[i] = c;
                    String newString = new String(tempChars);
                    if(wordList.contains(newString)){
                        queue.add(new Node(newString, tempPath+1)); // tempPath+1
                        wordList.remove(newString); // do not forget to remove it from wordList, otherwise it will overwrite.
                    }
                    tempChars[i] = temp; //dont forget to put it back!!!!
                }
            }
        }
        return 0;
    }
    
    public class Node{
        String word;
        int path;
        public Node(String word, int path){
            this.word = word;
            this.path = path;
        }
    }
}