public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int result = 0;
        
        int i = 0; 
        while(i< s.length()){
            int j = i+1;
            if(j < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(j))){
                result += map.get(s.charAt(j))-map.get(s.charAt(i));
                i+=2;
            } else{
                result+=map.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}