//存iterator是个最聪明的想法！！！！放在Queue里面
//每次弹出来，用next pop掉一个值，再塞回queue里面。
public class ZigzagIterator {
    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator>();
        if(!v1.isEmpty()) queue.add(v1.iterator());
        if(!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> iter = queue.remove();
        int res = iter.next();
        if(iter.hasNext()) queue.add(iter);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */