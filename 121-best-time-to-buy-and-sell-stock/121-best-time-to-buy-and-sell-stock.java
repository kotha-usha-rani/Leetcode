class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)
            return 0;
        int stock = prices[0];
        int today = 0;
        int max = 0;
        for(int i=1 ; i<prices.length ; i++){
            today = prices[i];
            if(stock < today)
                max = Math.max(today-stock, max);
            else
                stock = Math.min(stock, today);
        }
        return max;
    }
}