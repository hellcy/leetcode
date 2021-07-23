class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length * 2];
        
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = nums[i % length];
        }
        
        return ans;
    }
}