public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        } else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
            map.put(key,node);
        } else{
            Node node = new Node(key, value);
            if(map.size() == capacity){
                map.remove(end.key);
                remove(end);
                setHead(node);
            } else{
                setHead(node);
            }
            map.put(key,node);
        }
    }
    
    public void remove(Node n){
        if(n.prev!=null){
            n.prev.next = n.next;
        } else{
            head = n.next;
        }
        
        if(n.next!=null){
            n.next.prev = n.prev;
        } else{
            end = n.prev;
        }
    }
    
    
    public void setHead(Node n){
        n.next = head;
        n.prev = null;
        if(head!=null) head.prev = n;
        head = n;
        if(end == null) end = head;
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}