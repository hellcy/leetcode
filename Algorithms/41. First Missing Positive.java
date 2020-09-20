class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
            1. make all negative number greater than nums.length + 1, so they won't affect our ans
            2. mark all visit number to its negative value (number = -number)
            3. the first positive number is the ans
        */
        
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }
        
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]) - 1;
            if (num < n && nums[num] > 0) {
                nums[num] = -nums[num];
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}