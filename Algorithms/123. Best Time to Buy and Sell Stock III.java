class Solution {
    public int maxProfit(int[] prices) {
        /*
            similar to Buy and Sell stock II
            but this time we can only make up to two transactions 
            
            we have 5 different stages
            1. before buy the first time
            2. after buy and before sell the first time
            3. after sell and before buy the second time
            4. after buy and before sell the second time
            5. after sell the second time
            
            f[N][S]: N: number of days, S: stages
            
            for stage 0,2,4: at these stages we don't have stock
            f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1] + Price(i - 1) - Price(i - 2))
            
            for stage 1,3 at these stages we have stock
            f[i][j] = Math.max(f[i - 1][j] + Price(i - 1) - Price(i - 2), f[i - 1][j - 1])
        */
        
        
        int[][] dp = new int[prices.length + 1][5];
        
        for (int i = 2; i < 5; ++i) {
            dp[0][i] = 0;
        }
        
        
        for (int i = 1; i <= prices.length; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (j > 0) {
                     if (j % 2 == 0) {
                        // we don't have stock
                        if (j > 0 && i > 1) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);   
                    } else {
                        // we have stock
                        if (j >= 1 && i > 1) dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i - 1][j - 1]);
                    }   
                }
            }
        }
        
        int length = prices.length;
        return Math.max(dp[length][0], Math.max(dp[length][2], dp[length][4]));
    }
}