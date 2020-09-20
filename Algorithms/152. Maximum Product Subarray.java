class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int current = nums[i];
            int tempmax = Math.max(current, Math.max(max * current, min * current));
            min = Math.min(current, Math.min(max * current, min * current));
            
            max = tempmax;
            ans = Math.max(ans, max);

        }
        
        
        return ans;
    }
}