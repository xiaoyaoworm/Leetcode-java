public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        int j = citations.length-1;
        while(i<j){
            int temp = citations[i];
            citations[i] = citations[j];
            citations[j] = temp;
            i++;
            j--;
        }
        
        for(int k = 0; k < citations.length; k++){
            if(k>=citations[k]) return k;
        }
        return citations.length;
    }
}