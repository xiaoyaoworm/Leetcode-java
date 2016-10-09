public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        
        HashMap<Integer, Integer> intersaction = new HashMap<Integer, Integer>();
        
        for(int n1: nums1){
            if(map1.containsKey(n1)) map1.put(n1, map1.get(n1)+1);
            else map1.put(n1,1);
        }
        
        int count = 0;
        for(int n2: nums2){
            if(map1.containsKey(n2)){
                if(intersaction.containsKey(n2)){
                    intersaction.put(n2, intersaction.get(n2)+1);
                } else{
                    intersaction.put(n2, 1);
                }
                count++;
                if(map1.get(n2) == 1) map1.remove(n2);
                else map1.put(n2, map1.get(n2)-1);
            }
        }
        
        int[] res = new int[count];
        int k = 0;
        Iterator<Integer> iterator = intersaction.keySet().iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            for(int i = 0; i < intersaction.get(key); i++){
                res[k] = key;
                k++;
            }
        }
        return res;
    }
}

// What if elements of nums2 are stored on disk, and the memory is
// limited such that you cannot load all elements into the memory at
// once?
// If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

// If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
// Follow up有点意思。 External sort is like load limited k sources into memory, n is the total number needs to be sorted. the time is log_k(N/M) 
// http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L17-ExternalSortEX2.htm