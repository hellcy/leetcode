class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            prefix product and suffix product
            No extra array
        */
        int[] ans = new int[nums.length + 1];
        ans[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        for (int i = nums.length - 2; i >= 0; --i) {
            ans[i] = ans[i] * nums[i + 1];
            nums[i] = nums[i] * nums[i + 1];
        }
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = ans[i];
        }
        
        return nums;
    }
}