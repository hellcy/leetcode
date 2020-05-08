class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
            接龙型动态规划
            1. 数字不能交换
            2. 暴力时间复杂度为O(2^n)
            3. 求解为最大值
            以上三点表示可以使用动态规划
            number of total subsequence 2^n
            
            初始化
            把所有的dp点都设成1，因为我们可以从任何一个点出发
            
            方程
            对于每一个点来说，遍历他之前的比它小的所有的点， 取他们的最大值加上1
            
            答案
            找到所有dp值中的最大值
        */
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}