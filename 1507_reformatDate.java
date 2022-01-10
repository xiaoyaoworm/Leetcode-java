class Solution {
    public String reformatDate(String date) {
        String[] arr = date.split(" ");
        StringBuffer sb = new StringBuffer();
        sb.append(arr[2]).append("-").append(getMonth(arr[1])).append("-").append(getDate(arr[0]));
        return sb.toString();
    }
    
    public String getDate(String str){
        if(str.length() == 3) return "0"+ str.substring(0,1);
        else return str.substring(0,2);
    }
    
    public String getMonth(String str){
        HashMap<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        return map.get(str);
    }
}