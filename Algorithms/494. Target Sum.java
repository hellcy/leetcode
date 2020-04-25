class Solution {
    /*
        DFS
    */
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0, length = 0;
        
        helper(nums, length, sum, S, 0);
        return count;
    }
    
    private void helper(int[] nums, int length, int sum, int S, int start) {
        if (length == nums.length) {
            //System.out.println(sum);
            if (sum == S) {
                count++;
            }
        } else {
            helper(nums, length + 1, sum + nums[start], S, start + 1);
            helper(nums, length + 1, sum - nums[start], S, start + 1);
        }
    }
}