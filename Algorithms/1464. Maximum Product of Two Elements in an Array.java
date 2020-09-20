class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                max = Math.max(max, check(nums[i], nums[j]));
            }
        }
        
        return max;
    }
    
    private int check(int i, int j) {
        return (i - 1) * (j - 1);
    }
}