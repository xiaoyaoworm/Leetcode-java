//最简单的一到sliding window题目。用一个26位数组mark出现字符的个数。
//当最大的字符count+k < end+1-start （从当前的start到当前的end，两边都包含的长度）说明我们这个window大了，需要移动左边了。
//在左边界右移后，不断取最大值即可。
public class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        
        int res = 0;
        int maxCount = 0;
        
        for(int end = 0; end < len; end++){
            maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);
            while(end+1-start-maxCount > k){
                count[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}