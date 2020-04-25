class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
            Two pointers
        */
        int low = 0;
        int high = 1;
        int length = nums.length;
        int[] array = new int[2];
        while (low < length && high < length) {
            if (low != high && nums[low] + nums[high] == target) {
                array[0] = low;
                array[1] = high;
                break;
            } else {
                high++;
            }
            
            if (high == length) {
                low++;
                high = low + 1;
            }
        }
        return array;
    }
}