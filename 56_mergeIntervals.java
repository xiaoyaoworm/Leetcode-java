//http://xiaoyaoworm.com/blog/2015/04/03/%E6%96%B0leetcode-sort-3-merge-intervals/

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
        List<Interval> resultList = new ArrayList<Interval>();
        if(intervals == null || intervals.size()==0) return resultList;
        
        Comparator<Interval> comparator = new Comparator<Interval>(){
            public int compare(Interval x, Interval y){
                return x.start -y.start;
            }            
        };
        Collections.sort(intervals, comparator);
        
        Interval base = intervals.get(0);
        int k = 1;
        while(k < intervals.size()){
            Interval current = intervals.get(k);
            if(current.start <= base.end){
                if(current.end > base.end){
                    base.end = current.end;
                }
            } else {
                resultList.add(base);
                base = intervals.get(k);
            }
            k++;
        }
        resultList.add(base);
        return resultList;
    }
}