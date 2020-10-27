public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        
        /*
            sequence + state
            
            think about the last step
            to change A[i - 1] to X, cost is |A[i - 1] - X|
            need to make sure |X - B[i - 2]| <= target
            
            but we don't know B[i - 2]
            we need to save B[i - 2] in our dp state
        */
        
        int n = A.size();
        
        int[][] dp = new int[n + 1][101];
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= 100; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= 100; ++k) {
                    if (k >= j - target && k <= j + target) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i - 1)));
                    }
                }

            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; ++i) {
            ans = Math.min(ans, dp[n][i]);
        }
        
        return ans;
    }
}