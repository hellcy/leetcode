class Solution {
    public int numSquares(int n) {
        /*
            parition dp
            dp[i] = min(dp[i - j^2] + 1)
        */
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        
        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
            //System.out.println(dp[i]);
        }
        
        
        
        return dp[n];
    }
}