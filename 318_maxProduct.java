// because one integer has 32 bits, words are all lower case, which is 26 less than 32.
// we use one integer instead of hashmap to store all chars in this words.
// so abcd will become 000000....000001111(last one means it has 'a', last second means it has 'b')..
// what we do is use | nums[i] if any bit is set as 1, so it will become 1 forever, 1 | anything = 1. so (1 << shift) will move it to position, set as 1

//The rest are easy, n^2, use i and j, i from 0~ len-2, j from 1~ len-1. if this two (nums[i] & nums[j]) == 0 dont forget this ()!!!
//get the maximum product of their length.

public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int len = words.length;
        int[] nums = new int[len]; //we will convert all words into one num
        for(int i = 0; i < len; i++){
            String word = words[i];
            for(char c: word.toCharArray()){
                int shift = c-'a';
                nums[i] |= (1 << shift);
            }
        }
        int res = 0;
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if((nums[i] & nums[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}