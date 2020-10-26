class Solution {
    public boolean isMatch(String s, String p) {
        /*
            double sequence dp
            
            similar to 10. Regular Expression Mathcing
            
            if the last character of p is not '*':
                if (s[i - 1] == p[i - 1] || p[j - 1] == '?') dp[i][j] = dp[i - 1][j - 1]
            if the last character of p is '*'
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
        */
        
        int n = s.length();
        int m = p.length();
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i <= m; ++i) {
            dp[0][i] = p.charAt(i - 1) == '*' ? dp[0][i - 1] : false;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                char c = p.charAt(j - 1);
                if (c == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == c;
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[n][m];
    }
}