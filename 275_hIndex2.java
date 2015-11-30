public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(citations[mid] == len-mid) return len-mid;
            else if(citations[mid] > len-mid) end = mid-1;
            else start = mid+1;
        }
        return len - start;
    }
}