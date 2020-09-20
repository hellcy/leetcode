class Solution {
    public int change(int amount, int[] coins) {
        /*
            backpack dp
            dp[i] = dp[i - coins[j]]
            i: total amount 
            coins[j]: amount of coin j
            dp[i]: number of ways to get amount of i
            
            Note: this problem is similar to Combination Sum IV, but there is no order in the answer, so we need to swap the for loop
            calculate dp coin by coin
        */
        if (amount == 0) return 1;
        int n = coins.length;
        if (n == 0) return 0;
        
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }
        }
        
        return dp[amount];
    }
}