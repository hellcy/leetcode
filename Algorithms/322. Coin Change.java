class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
            max min dp
            O(m*n)
            m: number of coins
            n: amount
        */
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            int current = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    current = Math.min(current, dp[i - coin] + 1);
                }
            }
            dp[i] = current;
        }
        
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}