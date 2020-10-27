/*
 * @lc app=leetcode id=1621 lang=java
 *
 * [1621] Number of Sets of K Non-Overlapping Line Segments
 */

// @lc code=start
class Solution {
    public int numberOfSets(int n, int m) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n][m + 1];

        for (int i = 1; i <= m; ++i) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = 0;
                for (int k = 1; k <= i - j; ++k) {
                    if (j - k >= 0) dp[i][j] += dp[i - k][j] + dp[i - k][j - k];
                }
            }
        }

        return dp[n - 1][m];
    }
}
// @lc code=end

