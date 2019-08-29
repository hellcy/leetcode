class Solution {
    public int maxSubArray(int[] nums) {
        /*
            dynamic programming
        */
        if (nums.length == 0) return 0;
        int[] maxArray = new int[nums.length];
        
        maxArray[0] = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            maxArray[i] = Math.max(nums[i], nums[i] + maxArray[i - 1]);
            if (maxArray[i] > maxArray[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxArray[maxIndex];
    }
}