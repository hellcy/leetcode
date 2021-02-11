class Solution {
    public int maxAbsoluteSum(int[] nums) {
        /*
            Kadane's algorithm twice
        */
        int n = nums.length;
        int curmax = 0, max = Integer.MIN_VALUE;
        int curmin = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            curmax = Math.max(nums[i], curmax + nums[i]);
            max = Math.max(max, curmax);

            curmin = Math.min(nums[i], curmin + nums[i]);
            min = Math.min(min, curmin);
        }

        return Math.max(max, Math.abs(min));
    }
}