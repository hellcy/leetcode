class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
            double sequence dp
            dp[i][j] = Math.max(dp[i - 1][j - 1] + 1 (text1[i] == text2[j]), Math.max(dp[i][j - 1], dp[i - 1][j]))
            i: length of first string
            j: legnth of second string
            
            Time: O(MN)
            Space: O(MN)
        */
        
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        
        return dp[n][m];
    }
}