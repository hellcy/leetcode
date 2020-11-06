/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {
    int[] presum;
    public NumArray(int[] nums) {
        presum = new int[nums.length];
        if (nums.length == 0) return;
        presum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            presum[i] = presum[i - 1] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        int num = presum[i];
        if (i > 0) num -= presum[i - 1];
        int diff = val - num;
        for (int j = i; j < presum.length; ++j) {
            presum[j] += diff;
        }
    }
    
    public int sumRange(int i, int j) {
        int ans = presum[j];
        if (i > 0) ans -= presum[i - 1];
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

