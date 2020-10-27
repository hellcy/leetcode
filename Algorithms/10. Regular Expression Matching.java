class Solution {
    public boolean isMatch(String s, String p) {
        /*
            double sequence dp
            
            think from the last character
            init: 
                1. "" == "", so dp[0][0] = true
                2. if s is empty, 
                    if last character of p is not *, dp[0][i] = false  
                    else dp[0][i] = dp[0][i - 2]
                    
            1. if last character of p is not '.', we don't care of the last character of s, dp[i][j] = dp[i - 1][j - 1]
            2. if last character of p is an English character, it has to match with the last character of s, otherwise return false
            3. if last character of p is '*', look at second last character
                if it is an English character, dp[i][j] = dp[i - 1][j] and s[i - 1] == p[j - 2]
                if it is a dot '.', dp[i][j] = dp[i][j] = dp[i - 1][j]
            
        */
        
        int n = s.length();
        int m = p.length();
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i <= m; ++i) {
            if (p.charAt(i - 1) != '*') {
                dp[0][i] = false;
            } else {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) != '*') {
                    dp[i][j] = (p.charAt(j - 1) == s.charAt(i - 1) && dp[i - 1][j - 1]);
                } else {
                    char c = p.charAt(j - 2);
                    if (c == '.') {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = (s.charAt(i - 1) == c && dp[i - 1][j]);
                    }
                    dp[i][j] |= dp[i][j - 2];
                }
            }
        }
        
        return dp[n][m];
    }
}