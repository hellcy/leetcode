class Solution {
    public int[] runningSum(int[] nums) {
        int total = 0;
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            total += nums[i];
            array[i] = total;
        }
        
        return array;
    }
}