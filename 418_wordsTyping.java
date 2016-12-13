//Ref: https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence)+" ";
        int len = str.length();
        int start = 0;
        for(int i = 0; i < rows; i++){
            start+=cols;
            if(str.charAt(start%len)== ' ') start++;
            else{
                while(start > 0 && str.charAt((start-1)%len)!=' '){
                    start--;
                }
            }
        }
        return start/len;
    }
}