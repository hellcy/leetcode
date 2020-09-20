class Solution {
    public int maxProfit(int k, int[] prices) {
        /*
            Similar to Buy and Sell III, but we can make up to k times of transactions
            
            if K > N / 2, the question can be simplfied to Buy and Sell II
            if K == 2, the question is the same as Buy and Sell III
            
            now we have k * 2 + 1 different stages
        */
//         int length = prices.length;
//         int max = 0;
//         if (k > length / 2) {
//             for (int i = 1; i < length; ++i) {
//                 if (prices[i] > prices[i - 1]) {
//                     max += prices[i] - prices[i - 1];
//                 }
//             }
//             return max;
//         }
        
//         int[][] dp = new int[prices.length + 1][k * 2 + 1];
        
//         int stages = dp[0].length;
//         for (int i = 1; i <= prices.length; ++i) {
//             for (int j = 0; j < stages; ++j) {
//                 if (j > 0) {
//                      if (j % 2 == 0) {
//                         // we don't have stock
//                         if (j > 0 && i > 1) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);   
//                     } else {
//                         // we have stock
//                         if (j >= 1 && i > 1) dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i - 1][j - 1]);
//                     }   
//                 }
//             }
//         }
        
//         for (int i = 0; i < stages; i = i + 2) {
//             max = Math.max(max, dp[length][i]);
//         }
//         return max;
        
        /*
            with space optimization
        */
        int length = prices.length;
        int max = 0;
        if (k > length / 2) {
            for (int i = 1; i < length; ++i) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }
        
        int[][] dp = new int[2][k * 2 + 1];
        
        int stages = dp[0].length;
        int old = 0, now = 0;
        for (int i = 1; i <= prices.length; ++i) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < stages; ++j) {
                if (j > 0) {
                     if (j % 2 == 0) {
                        // we don't have stock
                        if (j > 0 && i > 1) dp[now][j] = Math.max(dp[old][j], dp[old][j - 1] + prices[i - 1] - prices[i - 2]);   
                    } else {
                        // we have stock
                        if (j >= 1 && i > 1) dp[now][j] = Math.max(dp[old][j] + prices[i - 1] - prices[i - 2], dp[old][j - 1]);
                    }   
                }
            }
        }
        
        for (int i = 0; i < stages; i = i + 2) {
            max = Math.max(max, dp[now][i]);
        }
        return max;
    }
}