//http://xiaoyaoworm.com/blog/2015/04/09/%E6%96%B0leetcode-sort-7-insert-interval/

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
        List<Interval> resultList = new ArrayList<Interval>();
        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                resultList.add(interval);
            } else if(interval.start > newInterval.end){
                resultList.add(newInterval);
                newInterval = interval;
            } else if(interval.start <= newInterval.end || interval.end >= newInterval.start){
                newInterval = new Interval(Math.min(interval.start,newInterval.start),Math.max(interval.end,newInterval.end));
            }
        }
        resultList.add(newInterval);
        return resultList;
    }
}