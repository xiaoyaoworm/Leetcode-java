//Two pointer problem, this is easy.
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        int i = 0;
        int j = 0;
        while(i< s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else{
                j++;
            }
        }
        if(i == s.length()) return true;
        return false;
    }
}


// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
//and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

//See Reference here: copy from here: https://discuss.leetcode.com/topic/58367/binary-search-solution-for-follow-up-with-detailed-comments

// Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
    // Eg-1. s="abc", t="bahbgdca"
    // idx=[a={1,7}, b={0,3}, c={6}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=3
    //  i=2 ('c'): prev=6 (return true)
    // Eg-2. s="abc", t="bahgdcb"
    // idx=[a={1}, b={0,6}, c={5}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=6
    //  i=2 ('c'): prev=? (return false)
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }
        
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }


//About j <0 part, here is the explanation:

// If it's returning a negative value it's not found:
// http://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html

// public static int binarySearch(Object[] a,
//                                Object key)

// Returns: index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). 
// The insertion point is defined as the point at which the key would be inserted into the array: 
// the index of the first element greater than the key, 
// or a.length if all elements in the array are less than the specified key. 
// Note that this guarantees that the return value will be >= 0 if and only if the key is found.