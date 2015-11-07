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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for(Interval current: intervals){
            if(current.end < newInterval.start){
                result.add(current);
            } else if(newInterval.end < current.start){
                result.add(newInterval);
                newInterval = current;
            } else{
                newInterval = new Interval(Math.min(newInterval.start, current.start),Math.max(newInterval.end,current.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}