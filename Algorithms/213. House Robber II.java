class Solution {
    public int rob(int[] nums) {
        /*
            sequence dp
            similar to house robber I
            calculate two times
            1. calculate without the first house
            2. calculate without the last house
        */
                
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length - 1];

        int first = 0, second = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length - 1; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        first = dp[nums.length - 2];
        
        dp = new int[nums.length - 1];
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        
        for (int i = 2; i < nums.length - 1; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + 1]);
        }
        
        second = dp[nums.length - 2];
        
        return Math.max(first, second);
    }
}