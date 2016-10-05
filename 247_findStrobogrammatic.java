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
    
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    //Attention, if we want to get n, we need to get n-2, n-2 can have such 0XXX0 scenario, but n shouldn't.
    public List<String> helper(int m, int n){ 
        List<String> res = new ArrayList<String>();
        
        if(m == 0) res.add(""); //This is m not n
        else if(m == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else{
            List<String> list = helper(m-2, n);
            for(String str: list){
                for(Character c: map.keySet()){
                    if(m == n && c == '0') continue; //Attention!!! This is the part I mentioned.
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