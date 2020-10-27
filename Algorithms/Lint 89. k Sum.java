public class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int x, int target) {
        // write your code here
        /*
            backpack dp
        */
        
        int n = A.length;
        int[][][] dp = new int[n + 1][x + 1][target + 1];
        
        for (int i = 0; i <= n; ++i) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= x;++j) {
                if (j > i) continue;
                for (int k = 0; k <= target; ++k) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (k - A[i - 1] >= 0) dp[i][j][k] += dp[i - 1][j - 1][k - A[i - 1]]; 
                }
            }
        }
        
        return dp[n][x][target];
    }
}