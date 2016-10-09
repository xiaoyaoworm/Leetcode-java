public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int n: nums1){
            set1.add(n);
        }
        for(int n: nums2){
            set2.add(n);
        }
        
        HashSet<Integer> set = findIntersaction(set1,set2);
        //Also Iterator needs <Integer> otherwise it will consider as Object
        Iterator<Integer> iterator = set.iterator(); //HashSet there is no keySet, only HashMap has it.
        int[] res = new int[set.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = iterator.next();
        }
        return res;
    }
    
    public HashSet<Integer> findIntersaction(HashSet<Integer> set1, HashSet<Integer> set2){
        HashSet<Integer> res = new HashSet<Integer>();
        if(set1.size() > set2.size()) return findIntersaction(set2, set1);
        Iterator<Integer> iterator = set1.iterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if(set2.contains(n)){
                res.add(n);
            }
        }
        return res;
    }
}