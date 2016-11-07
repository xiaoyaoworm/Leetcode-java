//Convert based on first character
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return result;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i = 0; i < strings.length; i++){
            String bitStr = getBit(strings[i]);
            if(map.containsKey(bitStr)){
                map.get(bitStr).add(strings[i]);
            } else{
                List<String> temp = new ArrayList<String>();
                temp.add(strings[i]);
                map.put(bitStr, temp);
            }
        }
        for(String str: map.keySet()){
            List<String> list = map.get(str);
            Collections.sort(list);//dont forget to sort!!
            result.add(list);
        }
        return result;
    }
    
    public String getBit(String str){
        if(str == null || str.length() == 0) return str;
        char c = str.charAt(0);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            int bit = str.charAt(i)-c;
            if(bit < 0) bit+=26;
            if(sb.length()!=0) sb.append(",");//dont forget this!!! 
            //because abc can be same as am, becasue b-a = 1, c-a = 2, m-a = 12. SAME!!!
            sb.append(bit);
        }
        return sb.toString();
    }
}



//Convert GAP!!!
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return result;
        
        List<String> singleList = new ArrayList<String>();
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str:strings){
            if(str.length() == 1) singleList.add(str);
            else{
                String weight = calculateWeight(str);
                if(map.containsKey(weight)){
                    map.get(weight).add(str);
                } else{
                    List<String> list = new ArrayList<String>();
                    list.add(str);
                    map.put(weight,list);
                }
            }
        }
        if(singleList.size() !=0){
            result.add(singleList);
        }
        
        for(String k: map.keySet()){
            result.add(map.get(k));
        }
        return result;
    }
    
    public String calculateWeight(String str){
        StringBuffer sb = new StringBuffer();
        char[] arr = str.toCharArray();
        int i = 0;
        int j = 1;
        while(j < str.length()){
            if(sb.length() != 0) {
                sb.append(",");
            }
            int gap = arr[j]-arr[i];
            if(gap < 0) gap+=26;
            sb.append(gap);
            i++;
            j++;
        }
        return sb.toString();
    }
}