class Solution {
    public int mctFromLeafValues(int[] arr) {
        /*
            range dp
            
            mat: save the current max leaf value from i to j
            dp: save the answer from i to j
        */
        int n = arr.length;
        
        int[][] dp = new int[n + 1][n + 1];
        int[][] mat = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; ++i) {
            mat[i][i] = arr[i - 1];
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                mat[i][j] = Math.max(mat[i][j - 1], arr[j - 1]);
            }
        }
        
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + mat[i + 1][k] * mat[k + 1][j]);
                }
            }
        }
        
        return dp[0][n];
    }
}