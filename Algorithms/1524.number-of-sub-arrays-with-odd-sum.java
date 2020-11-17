/*
 * @lc app=leetcode id=1524 lang=java
 *
 * [1524] Number of Sub-arrays With Odd Sum
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr) {
        /*
            sequence dp
            if (dp[i + 1][j] && arr[i] % 2 == 0) dp[i][j] = true;
            else if (!dp[i + 1][j] && arr[i] % 2 != 0) dp[i][j] = true;
        */

        int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = arr[i] % 2 != 0;
            if (dp[i][i]) count++;
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (dp[i + 1][j] && arr[i] % 2 == 0) dp[i][j] = true;
                else if (!dp[i + 1][j] && arr[i] % 2 != 0) dp[i][j] = true;
                
                if (dp[i][j]) count++;
            }
        }

        return count;
    }
}
// @lc code=end

