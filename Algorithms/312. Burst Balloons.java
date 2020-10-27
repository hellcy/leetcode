class Solution {
    public int maxCoins(int[] nums) {
        /*
            range dp
            
            dp[i][j] = max(i + 1 <= k <= j - 1) {dp[i][k], dp[k][j], nums[i] * nums[k] * nums[j]}
            
            Time: O(N^3)
            Space: O(N^2)
        */
        
        int n = nums.length;
        
        // add non-breakable balloons at begining and end, update length n
        int[] array = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            array[i] = nums[i - 1];
        }
        
        array[0] = 1;
        array[n + 1] = 1;
        
        n += 2;
        
        int[][] dp = new int[n][n];

        // calculate answer from len small to large
        // Note: here we are not using start and end index i and j
        // we are using start index i and length len
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                dp[i][j] = 0;
                for (int k = i + 1; k <= j - 1; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + array[i] * array[k] * array[j]);
                }
            }
        }
            
        
        return dp[0][n - 1];
    }
}