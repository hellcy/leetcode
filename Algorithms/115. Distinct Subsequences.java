class Solution {
    public int numDistinct(String s, String t) {
        /*
            double sequence dp
            加法原理
            当最后一个字母相等时，dp的结果为：前i - 1个字母组成j - 1个字母的个数 + 前i - 1个字母组成j个字母的个数
        */
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
        }
        
        return dp[n][m];
    }
}