public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update: updates){
            int i = update[0];
            int j = update[1];
            int add = update[2];
            
            res[i] += add;
            if(j+1 < length){
                res[j+1] -= add;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < length; i++){
            res[i]+=sum;
            sum = res[i];
        }
        return res;
    }
}