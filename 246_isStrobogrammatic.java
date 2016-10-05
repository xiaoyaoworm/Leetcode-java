//Iterative
public class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        
        int i = 0;
        int j = num.length()-1;
        while(i<=j){
            char first = num.charAt(i);
            char last = num.charAt(j);
            if(map.containsKey(first)){
                if (map.get(first)!=last) return false;
            } else return false;
            i++;
            j--;
        }
        return true;
    }
}

//Recursive
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null) return false;
        if(num.length() == 0) return true;
        if(num.length() == 1){
            if(num.equals("1") || num.equals("8") || num.equals("0")) return true; 
            else return false;
        } 
        char first = num.charAt(0);
        char last = num.charAt(num.length()-1);
        
        if(first == last && (first=='1' || first=='8' ||first=='0')){
            return isStrobogrammatic(num.substring(1, num.length()-1));
        }
        if(first!= last && ((first == '6' && last == '9') || (first == '9'&& last == '6'))){
            return isStrobogrammatic(num.substring(1, num.length()-1));
        }
        return false;
    }
}