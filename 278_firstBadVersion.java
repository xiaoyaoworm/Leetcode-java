/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n-1;
        return findBad(n,0,n-1);
    }
    
    public int findBad(int n, int start, int end){
        if(start == end) return start+1;
        int mid = start+(end-start)/2;
        if(start < end){
            if(isBadVersion(mid+1)) {
                return findBad(n,start,mid); //Pay attention here, here is not mid-1
            } else{
                return findBad(n,mid+1,end);
            }
        }
        return 0;
    }
}