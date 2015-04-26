//http://xiaoyaoworm.com/blog/2015/04/03/%E6%96%B0leetcode-sort-2-sort-colors/

public class Solution {
    public void sortColors(int[] A) {
        int length = A.length;
        int l = 0;
        int r = length -1;
         
        int k = 0;
        int temp = 0;
        while(k< r+1){
            if(A[k] == 0){
                temp = A[k];
                A[k] = A[l];
                A[l] = temp;
                k++;
                l++;
            } else if(A[k] == 2){
                temp = A[k];
                A[k] = A[r];
                A[r] = temp;
                r--; 
                // Then only thing we need to pay attention to is that there is 
                // no need to add k this time, because k is not fixed there
            }
            else {
                k++;
            }
        }
    }
}