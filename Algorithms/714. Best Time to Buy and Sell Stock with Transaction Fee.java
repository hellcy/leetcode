class Solution {
    public int maxProfit(int[] prices, int fee) {
        /*
            Greedy
                At the end of the i-th day, we maintain cash, the maximum profit we could have if we did not have a share of stock, 
                and hold, the maximum profit we could have if we owned a share of stock.
                
                If I am holding a share after today, then either I am just continuing holding the share I had yesterday, 
                or that I held no share yesterday, but bought in one share today: hold = max(hold, cash - prices[i])
                
                If I am not holding a share after today, then either I did not hold a share yesterday, 
                or that I held a share yesterday but I decided to sell it out today: cash = max(cash, hold + prices[i] - fee).
                
                Make sure fee is only incurred once.
        */
        int cash = 0;
        int hold = -prices[0];
        
        for (int i = 0; i < prices.length; ++i) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        
        return cash;
    }
}