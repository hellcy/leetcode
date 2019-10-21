class Solution {
    public int triangleNumber(int[] nums) {
        /*
            Array
            Brute force
        */
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                for (int k = j + 1; k < length; ++k) {
                    if (nums[k] >= nums[i] + nums[j]) break;
                    else count++;
                }
            }
        }
        
        return count;
    }
}