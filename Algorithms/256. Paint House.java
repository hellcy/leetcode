class Solution {
    public int minCost(int[][] costs) {
        /*
            brute force 3^n
            sequence dp
            
            f[i][0] = min(f[i - 1][1], f[i - 1][2]) + cost(i - 1, 0)
            f[i][1] = min(f[i - 1][0], f[i - 1][2]) + cost(i - 1, 1)
            f[i][2] = min(f[i - 1][1], f[i - 1][0]) + cost(i - 1, 2)
            
            f[0][0] = f[0][1] = f[0][2] = 0
            
            Time: O(n)
        */
        
        if (costs == null || costs.length == 0) return 0;
        int length = costs.length;
        int[][] dp = new int[length + 1][3];
        
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i <= length; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }
        
        return Math.min(dp[length][0], Math.min(dp[length][1], dp[length][2]));
    }
}