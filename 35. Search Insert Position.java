class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
            when target value found in array or target value less than array's current value(value doesn't in array)
            return index i
        */
        int i = 0;
        for (; i < nums.length; ++i) {
            if (target == nums[i] || target < nums[i]) {
                break;
            }
        }
        
        return i;
    }
}