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