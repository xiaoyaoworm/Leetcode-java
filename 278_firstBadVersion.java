while中是<的情况，一定要返回start

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int mid = start+(end-start)/2;
            if(isBadVersion(mid)) end = mid;
            else start = mid+1;
        }
        return start;
    }
}


while中是<=的情况，要在内部定义好返回，if(start == end) return start; 
while外面返回-1.


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            if(start == end) return start; 
            int mid = start+(end-start)/2;
            if(isBadVersion(mid)){
                end = mid;
            } else{
                start = mid+1;
            }
        }
        return -1;
    }
}