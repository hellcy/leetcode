class Solution {
    public int rob(int[] nums) {
        /*
            Dynamic programming
                if length = 0, max = 0
                if length = 1, max = nums[0]
                if length = 2, max = max(nums[0], nums[1])
                if length = 3, max = max(maxOfFirstTwo, maxOfFirstOne + nums[2])
                
            so max(n) = max(max(n - 1), max(n - 2) + current)
        */
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        
        int prevmax = 0; // x = 0
        int currentmax = nums[0]; // x = 1
                
        for (int i = 1; i < length; ++i) {
            int temp = currentmax;
            currentmax = Math.max(prevmax + nums[i], currentmax);
            prevmax = temp;
        }
        
        return currentmax;
    }
}