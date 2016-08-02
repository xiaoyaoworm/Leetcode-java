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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Comparator<Interval> startComparator = new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        };
        Arrays.sort(intervals, startComparator);
        
        Comparator<Interval> endComparator = new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        };
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, endComparator);
        
        pq.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            Interval current = pq.poll();
            if(current.end <= intervals[i].start){
                current.end = intervals[i].end;
            } else{
                pq.offer(intervals[i]);
            }
            pq.offer(current);
        }
        return pq.size();
    }
}