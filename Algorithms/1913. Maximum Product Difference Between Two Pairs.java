class Solution {
    public int maxProductDifference(int[] nums) {
        // the difference is maximized when we choose two largest numbers and two smallest numbers
        
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length - 1] * nums[length - 2] - nums[0] * nums[1];
    }
}