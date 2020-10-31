class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        /*
            partition dp
        */
        
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < k; ++i) {
            max = Math.max(max, arr[i]);
            dp[i] = Math.max(max, arr[i]) * (i + 1);
        }
        
        for (int i = k; i < n; ++i) {
            dp[i] = 0;
            int max2 = 0;
            for (int j = 1; j <= k; ++j) {
                max2 = Math.max(max2, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + max2 * (j));
            }
        }
        
        return dp[n - 1];
    }
}