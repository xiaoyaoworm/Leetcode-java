public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1) return s;
        int i = 0;
        int j = s.length()-1;
        char[] arr = s.toCharArray();
        while(i < j){
            while(i < j && !isVowel(arr[i])){ // dont forget i < j in it!!!
                i++;
            }
            while(i < j && !isVowel(arr[j])){ // dont forget i < j in it!!!
                j--;
            }
            if(i >= j) break; // dont forget check i >= j!!!
            
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
        return new String(arr);
    }
    
    public boolean isVowel(char c){
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        return set.contains(c);
    }
}