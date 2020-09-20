class Solution {
    public int longestPalindromeSubseq(String s) {
        /*
            1. sequence dp
            i, j: indexes
            if characters at i and j are the same, ans is the smaller subsequence at (i + 1, j - 1) + 2
            if characters at i and j are not the same, ans is the max from either subsequence at (i + 1, j) and (i, j + 1)
            
            Note: to get the ans at dp[i][j], we need to know i + 1 and j - 1
            so i should start at the end, and j should start at the begining. Also j should always greater than i
            
            if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2
            else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1])
        */
        
        int n = s.length();
        if (n == 0) return 0;
        
        int[][] dp = new int[n][n];
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (cs[i] == cs[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[0][n - 1];
    }
}