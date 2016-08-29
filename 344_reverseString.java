public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() <= 1) return s;
        int i = 0;
        int j = s.length()-1;
        char[] arr = s.toCharArray();
        char temp = arr[0];
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}