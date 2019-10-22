class Solution {
    public int search(int[] nums, int target) {
        /*
            Binary Search
                first find how many rotates the array did
                next sort the array to find the index of target number, add by the number of rotates
                keep the reminder if exceed the length of array
                return -1 if not found
        */
        int point = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) point = i;
        }
        
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return (mid + point) % nums.length;
            }
        }
        return -1;
    }
}