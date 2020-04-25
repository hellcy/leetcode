class Solution {
    public int findLengthOfLCIS(int[] nums) {
        /*
            Algorithm explained:
                keep track of the current and max count of continuous incresing subarray
                return max + 1
        */
        if (nums.length == 0) return 0;
        int count = 0;
        int max = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max + 1;
    }
}