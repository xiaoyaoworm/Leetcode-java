public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m <=n) return findMedian(nums1, nums2);
        else return findMedian(nums2,nums1);
    }
    
    public double findMedian(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        
        int start = 0;
        int end = m;  // not m-1!!!
        int sumIJ = (m+n+1)/2;
        
        int leftMax = 0;
        int rightMin = 0;
        
        while(start<=end){
            int i = start+(end-start)/2;
            int j = sumIJ-i;
            
            if(i>0 && j < n && A[i-1] > B[j]){
                end = i-1;
            }else if(j > 0 && i < m && B[j-1] > A[i]){
                start = i+1;
            } else{
                if(i == 0) leftMax = B[j-1];
                else if(j == 0) leftMax = A[i-1];
                else leftMax = Math.max(A[i-1], B[j-1]);
                
                if((m+n)%2 == 1) return leftMax;
                
                if(i == m) rightMin = B[j];
                else if(j == n) rightMin = A[i];
                else rightMin = Math.min(A[i],B[j]);
                return (leftMax+rightMin)/2.0; //2.0
            }
        }
        return 0;
    }
}