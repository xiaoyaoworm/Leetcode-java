//REF: https://discuss.leetcode.com/topic/46887/java-solution-using-treemap-real-o-logn-per-adding
//Copy from that url: Use TreeMap to easily find the lower and higher keys, the key is the start of the interval.
// Merge the lower and higher intervals when necessary. The time complexity for adding is O(logN) since lowerKey(), higherKey(), put() and remove() are all O(logN). It would be O(N) if you use an ArrayList and remove an interval from it.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> map;//two parameters!!, first is the start value of Interval!!!

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<Integer, Interval>(); //two parameters!!
    }
    
    public void addNum(int val) {
        if(map.containsKey(val)) return; //dont forget
        Integer l = map.lowerKey(val); //find the lower one before val, l is the start value , O(logN), return Integer!!!
        Integer h = map.higherKey(val); //find the higher one after val, h is the start value , O(logN)
        if(l!=null && h!= null && map.get(l).end +1 == val && val+1 == h){ //Combine l and h
            map.get(l).end = map.get(h).end; //combine
            map.remove(h);
        } else if(l!=null && map.get(l).end+1 >= val){ //>= is same scenario
            map.get(l).end = Math.max(map.get(l).end, val);
        } else if(h!=null && val+1 == h){
            map.put(val, new Interval(val, map.get(h).end)); //two parameters!!!
            map.remove(h);
        } else{
            map.put(val, new Interval(val, val));//two parameters!!!
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(map.values()); //values!!!! set
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */