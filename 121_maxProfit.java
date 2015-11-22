public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[] min = new int[prices.length];
        int profit = 0;
        min[0] = prices[0];
        for(int i= 1; i < prices.length; i++){
            if(min[i-1]>prices[i]){
                min[i] = prices[i];
            } else{
                min[i] = min[i-1];
            }
            profit = Math.max(profit, prices[i]-min[i]);
        }
        return profit;
    }
}