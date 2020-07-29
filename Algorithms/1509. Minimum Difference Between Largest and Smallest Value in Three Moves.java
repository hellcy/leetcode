class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 4) return 0;
        int length = nums.length;
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < 4; ++i) {
            if (ans > (nums[length - 1 - i] - nums[3 - i])) {
                ans = nums[length - 1 - i] - nums[3 - i];
            }
        }
        
        return ans;
    }
}