class Solution {
    public int search(int[] nums, int target) {
        /*
            Binary Search
        */
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}