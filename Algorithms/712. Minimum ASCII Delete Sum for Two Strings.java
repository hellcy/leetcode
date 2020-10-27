/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// @lc code=start
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        /*
            Same as Longest Common Subsequence
        */
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + s2.charAt(j - 1);
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + s1.charAt(i - 1);
                    continue;
                }

                dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j - 1), dp[i - 1][j] + s1.charAt(i - 1));
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }

        return dp[n][m];
    }
}
// @lc code=end

