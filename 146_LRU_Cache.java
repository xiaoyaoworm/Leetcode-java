public class LRUCache {
    int capacity;
    HashMap<Integer, DLinkNode> map;
    DLinkNode head = null;
    DLinkNode tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DLinkNode>();
        head = new DLinkNode(0,0);
        tail = new DLinkNode(0,0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    private void remove(DLinkNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    private void setHead(DLinkNode node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLinkNode node = map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        } else return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DLinkNode node = map.get(key);
            node.val = value;
            remove(node);
            setHead(node);
        } else{
            DLinkNode node = new DLinkNode(key,value);
            if(capacity == map.size()){
                map.remove(tail.prev.key); // remove map at first otherwise tail will be removed
                remove(tail.prev);
            }
            map.put(key, node);
            setHead(node);
        }
    }
    
    
    public class DLinkNode{
        int key;
        int val;
        DLinkNode next = null;
        DLinkNode prev = null;
        public DLinkNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}