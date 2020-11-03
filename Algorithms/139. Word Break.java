/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
            sequence dp
        */
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; ++j) {
            for (String str : wordDict) {
                int m = str.length();
                if (j - m >= 0 && s.substring(j - m, j).equals(str)) {
                    dp[j] |= dp[j - m];
                    //System.out.println(dp[0]);
                } 
            }
        }

        // for (int i = 0 ; i <= n ; ++i) {
        //     System.out.println(dp[i]);
        // }

        return dp[n];
    }
}
// @lc code=end

