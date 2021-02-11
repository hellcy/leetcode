class Solution {
    public int maxSumAfterOperation(int[] nums) {
        /*
            Kadane's algorithm + dp
            create n * 2 array
            first row represents the normal Kadane's curmax
            second row represents the curmax after we perform the operation nums[i] * nums[i], choose max out of below 3 situations
                1. we could already performed the operation before, so dp[i][1] = dp[i - 1][1] + nums[i];
                2. we could perform the operation now, we previous sum is less than zero: dp[i][1] = nums[i] * nums[i]
                3. we could perform the operation now and previous sum is greater than zero: dp[i][1] = dp[i - 1][0] + nums[i] * nums[i]
        */
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(nums[i], dp[i - 1][0] + nums[i]);
            dp[i][1] = Math.max(nums[i] * nums[i], Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0] + nums[i] * nums[i]));
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dp[i][1]);
        }

        return ans;
    }
}