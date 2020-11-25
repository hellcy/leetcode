class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        
        for (int i = 0; i < 5; ++i) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 5; ++j) {
                for (int k = 0; k < 5; ++k) {
                    if (j <= k) dp[i][j] += dp[i - 1][k];
                }   
            }
        }
        
        int total = 0;
        for (int i = 0; i < 5; ++i) {
            total += dp[n - 1][i];
        }
        
        return total;
    }
}