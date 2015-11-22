public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        int i = 0;
        while(i< arr1.length || i< arr2.length){
            if(i< arr1.length && i< arr2.length){
                if(Integer.valueOf(arr1[i])<Integer.valueOf(arr2[i])) return -1;
                else if(Integer.valueOf(arr1[i])>Integer.valueOf(arr2[i])) return 1;
            } else if(i< arr1.length){
                if(Integer.valueOf(arr1[i])!=0) return 1;
            } else if(i <arr2.length){
                if(Integer.valueOf(arr2[i])!=0) return -1;
            }
            i++;
        }
        return 0;
    }
}