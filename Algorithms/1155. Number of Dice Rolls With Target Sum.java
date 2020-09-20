class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (target > d * f) {
            return 0;
        }
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[d][Integer.max(target, f)];
        int i, j;
        for (j = 0; j < f; j ++) {
            dp[0][j] = 1;
        }
        for (i = 1; i < d; i ++) {
            for (j = 0; j < target; j ++) {
                if (j >= 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } 
                if (j >= f + 1) {
                    dp[i][j] -= dp[i - 1][j - f - 1];
                }
                dp[i][j] %= mod;
                if (dp[i][j] < 0)  {
                    dp[i][j] += mod;
                }
            }
        }
        return dp[d - 1][target - 1];
    }
}