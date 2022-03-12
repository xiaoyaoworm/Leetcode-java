//TLE, maybe we should use treeMap
class TimeMap {
    HashMap<String, LinkedList<Node>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        LinkedList<Node> list = new LinkedList<Node>();
        if(map.containsKey(key)) list = map.get(key);
        list.add(new Node(timestamp, value));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Node> m = map.get(key);
            int l = 0, r = m.size()-1;
            while(r>=l){
                int mid = l +(r-l)/2;
                if(m.get(mid).timestamp == timestamp){
                    return m.get(mid).value;
                }
                 if(m.get(mid).timestamp < timestamp){
                     l = mid+1;
                 } else{
                     r = mid-1;
                 }
            }
            if(r<0) return "";
            return m.get(r).value;
        }
        return "";
    }
    
    
    public class Node{
        public int timestamp;
        public String value;
        
        public Node(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    } 
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

//https://leetcode.com/problems/time-based-key-value-store/discuss/226663/TreeMap-Solution-Java
//Use:
//floorKey(key)-> the first greatest number <= given key;
//ceillingKey(key)_> the first smaller number >=given key;
 public class TimeMap {

    private Map<String,TreeMap<Integer,String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap==null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if(floor==null) {
            return "";
        }
        return treeMap.get(floor);
    }
}