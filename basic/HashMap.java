/**
 * Created by xiaoyaoworm on 7/4/16.
 */
public class HashMap<K,V>{
    int capacity;
    Entity[] arr;

    boolean nullKey;
    V nullValue;

    public HashMap (int capacity){
        this.capacity = capacity;
        this.arr = new Entity[capacity];

        nullKey = false;
        nullValue = null;
    }


    public class Entity<K,V>{
        K k;
        V v;
        Entity<K,V> next;

        public Entity (K k, V v){
            this.k = k;
            this.v = v;
            this.next = null;
        }
    }



    public int hashCode(K k){
        return (k.hashCode())%capacity;
    }

    public V get(K k){
        if(k == null){
            if(nullKey) return nullValue;
            else return null;
        }
        int hash = hashCode(k);
        Entity current = arr[hash];
        while(current!=null){
            if(current.k.equals(k)) return (V) current.v;
            current = current.next;
        }
        return null;
    }

    public void put(K k, V v){
        if(k == null){
            nullKey = true;
            nullValue = v;
            return;
        }
        int hash = hashCode(k);
        Entity current = arr[hash];
        if(current == null) {
            arr[hash] = new Entity(k,v);
            return;
        }
        Entity prev = null;
        while(current!=null){
            if(current.k.equals(k)){
                current.v = v;
                return;
            }
            prev = current;
            current = current.next;
        }
        if(current == null){
            prev.next = new Entity(k,v);
        }
    }

    public static void main(String[] args) {
        HashMap<Character, String>  map = new HashMap<Character, String>(5);

        System.out.println("TEST SET------");
        map.put('a', "1st string");
        map.put('b', "2nd string!");
        map.display();


        System.out.println("TEST PUT------");
        System.out.println(map.get('a'));
        System.out.println(map.get('c'));
        map.put('c', "okay test c");
        System.out.println(map.get('c'));
        map.display();

        System.out.println("TEST COLLISION------");
        map.put('d', "test d");
        map.put('e', "test E");
        map.display();


        System.out.println(map.get(null));
        map.put(null,"Leon");
        map.display();
        map.put(null,"Jerry");
        map.display();

    }


    public void display() {
        for (int i = 0; i < arr.length; i++) {
            Entity<K,V> node = arr[i];
            StringBuffer sb = new StringBuffer();
            while (node != null) {
                sb.append("[key: " + node.k + ", value: " + node.v + "], ");
                node = node.next;
            }
            if (sb.length() != 0)
                System.out.println(sb.toString());
        }
        if(nullKey){
            StringBuffer sb = new StringBuffer("[key: " + "null" + ", value: " + nullValue + "], ");
            System.out.println(sb.toString());
        }
        System.out.println();

    }
}