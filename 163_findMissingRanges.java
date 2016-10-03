public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        
        for(int n: nums){
            int justBelow = n-1;
            if(lower == justBelow) res.add(String.valueOf(lower));
            else if (lower < justBelow) res.add(lower+"->"+justBelow);
            lower = n+1;
        }
        if(lower == upper) res.add(String.valueOf(lower));
        else if(lower < upper) res.add(lower+"->"+upper);
        return res;
    }
}