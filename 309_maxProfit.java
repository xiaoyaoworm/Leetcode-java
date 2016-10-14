//See Reference here: Awesome explanation
//https://discuss.leetcode.com/topic/30421/share-my-thinking-process/2

//First O(N) space dp solution.
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] rest = new int[len];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        
        for(int i = 1; i < len; i++){
            if(i == 1){
                buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i]);
            } else{
                buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            }
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            rest[i] = Math.max(rest[i-1], Math.max(buy[i-1], sell[i-1]));
        }
        return Math.max(rest[len-1], Math.max(buy[len-1], sell[len-1]));
    }
}

//optimize to O(1) space, just need four variable there.
//buy, preBuy, sell, preSell, result should be sell in the end.
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        
        int buy = -prices[0];
        int sell = 0;
        int prevBuy = 0;
        int prevSell = 0;
        
        for(int i = 1; i < len; i++){
            prevBuy = buy;
            buy = Math.max(prevBuy, prevSell-prices[i]);
            prevSell = sell;
            sell = Math.max(prevSell, prevBuy+prices[i]);
        }
        return sell;
    }
}