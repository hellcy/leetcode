/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        /*
            sequence dp
        */
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i / 2; j >= 1; --j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    break;
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end

