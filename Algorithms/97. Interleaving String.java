class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
            double sequence dp
            think about the last step
            n: s1.length();
            m: s2.length();
            n + m: s3.length();
            
            dp[i][j] = if (s1.charAt(i) == s3.charAt(i + j)) dp[i - 1][j]
            dp[i][j] = if (s2.charAt(j) == s3.charAt(i + j)) dp[i][j - 1]
        */
        
        int n = s1.length();
        int m = s2.length();
        
        if (s3.length() != n + m) return false;
        
        boolean[][] dp = new boolean[n + 1][m + 1];
                
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                
                dp[i][j] = false;
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        
        return dp[n][m];
    }
}