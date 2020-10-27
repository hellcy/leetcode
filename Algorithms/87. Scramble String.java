class Solution {
    public boolean isScramble(String s1, String s2) {
        /*
            range dp
            
            s1 can be split into s1a and s1b
            s2 can be split into s2a and s2b

            if s1a can be scrambled into s2a or s2b
            and if s1b can be scrambled into s2b or s2a
            then we know s1 can be scrambled into s2
            
            dp[i][j][k] = OR(1 <= w <= k - 1) {f[i][j][w] AND f[i + w][j + w][k - w]}
            OR
            OR (1 <= w <= k - 1) {f[i][j + k - w][w] AND f[i + w][j][k - w]}
            
            i: start index of s1
            j: start index of s2
            k: length of s1 and s2 (they should always be the same)
            w: width, we can cut s1 and s2 at any point from 1 to k - 1
            
            Time: O(N^4)
            Space O(N^3)
            
        */
        
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j][1] = true;
            }
        }
        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                for (int j = 0; j <= n - k; ++j) {
                    // s1[i,...,i + k - 1]
                    // s2[j,...,j + k - 1]
                    dp[i][j][k] = false;
                    for (int w = 1; w <= k - 1; ++w) {
                        dp[i][j][k] = dp[i][j][k] || (dp[i][j][w] && dp[i + w][j + w][k - w]);
                    }
                    
                    for (int w = 1; w <= k - 1; ++w) {
                        dp[i][j][k] = dp[i][j][k] || (dp[i][j + k - w][w] && dp[i + w][j][k - w]);
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
}