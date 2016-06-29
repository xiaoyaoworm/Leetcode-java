/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return result; 
        
        
        Comparator<Interval> comparator = new Comparator<Interval>(){
            public int compare(Interval p, Interval q){
                return p.start - q.start;
            }
        };
        Collections.sort(intervals, comparator);
        
        Interval base = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(base.end < current.start){
                result.add(base);
                base = current;
            }
            base = new Interval(base.start, Math.max(base.end, current.end));
        }
        result.add(base);
        return result;
    }
}