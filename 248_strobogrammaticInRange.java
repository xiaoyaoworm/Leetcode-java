//基于247_findStrobogrammatic.java的解法。在原基础上，把range里面的count++。
public class Solution {
    HashMap<Character, Character> map;
    
    public Solution(){
        map = new HashMap<Character, Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
    }
    
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> res = new ArrayList<String>();
        
        for(int i = low.length(); i <= high.length(); i++){
            res.addAll(helper(i,i));
        }
        
        for(String str: res){
            if(str.length() == low.length() && str.compareTo(low) < 0) continue;
            if(str.length() == high.length() && str.compareTo(high) >0) continue;
            count++;
        }
        return count;
    }
    
    public List<String> helper(int m, int n){ 
        List<String> res = new ArrayList<String>();
        
        if(m == 0) res.add("");
        else if(m == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else{
            List<String> list = helper(m-2, n);
            for(String str: list){
                for(Character c: map.keySet()){
                    if(m == n && c == '0') continue;
                    StringBuffer sb = new StringBuffer();
                    sb.append(c);
                    sb.append(str);
                    sb.append(map.get(c));
                    res.add(sb.toString());
                }
                
            }
        }
        return res; 
    }
}