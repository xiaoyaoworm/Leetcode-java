//time：O(n)
//initial全为1
//从左到右扫一遍，更新所有candy值，
//从右往左扫一遍，更新所有candy值。

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length ==0) return 0;
        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        for(int i = 0; i < len-1; i++){
            if(ratings[i] < ratings[i+1]){
                candy[i+1] = Math.max(candy[i+1], candy[i]+1);
            } else{
                continue;
            }
        }
        
        for(int i = len-1; i> 0; i--){
            if(ratings[i-1] > ratings[i]){
                candy[i-1] = Math.max(candy[i-1], candy[i]+1);
            } else{
                continue;
            }
        }
        int sum = 0;
        for(int n: candy){
            sum+=n;
        }
        return sum;
    }
}