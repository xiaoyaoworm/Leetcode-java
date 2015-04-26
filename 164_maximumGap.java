//http://xiaoyaoworm.com/blog/2015/04/08/%E6%96%B0leetcode-sort-4-maximum-gap/

public class Solution {
    public int maximumGap(int[] num) {
        if(num == null || num.length < 2) return 0;
         
        int min = num[0];
        int max = num[0];
        for(int i = 1; i < num.length; i++){
            min = Math.min(num[i], min);
            max = Math.max(num[i], max);
        }
         
         
        Bucket[] buckets = new Bucket[num.length+1];
        for(int i= 0; i < num.length+1; i++){
            buckets[i] = new Bucket();
        }
         
        double interval = (double) num.length/(max-min);
         
        for(int i = 0; i < num.length; i++){
            int index = (int)(interval * (num[i]-min));
            if(buckets[index].low == -1){
                buckets[index].low = num[i];
                buckets[index].high = num[i];
            } else {
                buckets[index].low = Math.min(num[i],buckets[index].low);
                buckets[index].high = Math.max(num[i],buckets[index].high);
            }
        }
         
        int result = 0;
        int prev = buckets[0].high;
        for(int i = 1; i < buckets.length; i++){ // buckets.length!!!! not num.length!!!!
            if(buckets[i].low!=-1){
                result = Math.max(result, buckets[i].low - prev);
                prev = buckets[i].high;
            }
        }
        return result;
    }
     
     
     
    public class Bucket{
        int low;
        int high;
        public Bucket(){
            low = -1;
            high = -1;
        }
    }
}