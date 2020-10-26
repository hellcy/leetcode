class Solution {
    public int minDistance(String word1, String word2) {
        /*
            double sequence dp
            dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
            
            think the last character
            if word1[i - 1] == word2[j - 1]: dp[i][j] = dp[i - 1][j - 1]
            else:
                change the last character, answer equals to : dp[i][j] = dp[i - 1][j - 1] + 1
                insert a character the same as word2[j - 1]: dp[i][j] = dp[i - 1][j] + 1
                delete the last character from word2: dp[i][j] = dp[i][j - 1] + 1
            
            pick the minimum from above
        */
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = i;
        }
        
        for (int i = 1; i <= m; ++i) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Integer.MAX_VALUE;
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1);
            }
        }
        
        return dp[n][m];
    }
}