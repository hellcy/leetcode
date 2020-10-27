/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        /*
            sequence dp
            dp[i][j] = Math.max(dp[i + 1][j - 1], dp[i + 2][j], dp[i][j - 2])
        */
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i + 1 < n && j - 1 >= 0) {
                    if (cs[i] == '(' && cs[j] == ')' && (i == j + 2 || dp[i + 1][j - 1] == j - i - 1)) dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                    else dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1]);
                }
                if (i + 2 < n) {
                    if (cs[i] == '(' && cs[i + 1] == ')') {
                        if (i == j + 2 || dp[i + 2][j] == j - i - 1) {
                            dp[i][j] = Math.max(dp[i][j], dp[i + 2][j] + 2);
                        } else {
                            dp[i][j] = Math.max(dp[i][j], Math.max(dp[i + 2][j], 2));
                        }
                    } else dp[i][j] = Math.max(dp[i][j], dp[i + 2][j]);
                }
                if (j - 2 >= 0) {
                    if (cs[j - 1] == '(' && cs[j] == ')') {
                        if (i == j + 2 || dp[i][j - 2] == j - i - 1) {
                            dp[i][j] = Math.max(dp[i][j], dp[i][j - 2] + 2);
                        } else {
                            dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 2], 2));
                        }
                    }
                    else dp[i][j] = Math.max(dp[i][j], dp[i][j - 2]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end

