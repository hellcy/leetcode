class Solution {
    public boolean canPartition(int[] nums) {
        /*
            backpack dp
            pick 1 to n - 1 elemetns from the array let sum equals to total / 2
            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
            i: the first i-th elements
            j: total amount from the first i-th elements
        */
        
        int n = nums.length;
        if (n == 0) return false;
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 != 0) return false;
        total = total / 2;
        
        boolean[][] dp = new boolean[n][total + 1];
        
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= total; ++j) {
                dp[i][j] = dp[i - 1][j];
                
                if (j - nums[i - 1] >= 0) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        
        boolean ans = false;
        for (int i = 0; i < n; ++i) {
            if (dp[i][total]) ans = true;
        }
        
        return ans;
    }
}