class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = 0; i <= n - k; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }
        
        for (int i = 0; i < k; ++i) {
            ans[i] = nums[pos + i];
        }
        
        return ans;
    }
}