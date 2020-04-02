class Solution {
    public int search(int[] nums, int target) {
        /*
            Binary Search
                first find how many rotates the array did
                next sort the array to find the index of target number, add by the number of rotates
                keep the reminder if exceed the length of array
                return -1 if not found
        */
        // int point = 0;
        // for (int i = 1; i < nums.length; ++i) {
        //     if (nums[i] < nums[i - 1]) point = i;
        // }
        
        // Arrays.sort(nums);
        // int low = 0;
        // int high = nums.length - 1;
        // while (low <= high) {
        //     int mid = low + (high - low) / 2;
        //     if (nums[mid] > target) {
        //         high = mid - 1;
        //     } else if (nums[mid] < target) {
        //         low = mid + 1;
        //     } else {
        //         return (mid + point) % nums.length;
        //     }
        // }
        // return -1;

        /*
            Binary Search
            compare the mid number and the last number, 
            if mid number > last number
                if first number <= target < mid number
                we know that target number is in the first half of the array, and its sorted
                else we know target is in the second half of the array, and its a smaller rotated sorted array
            if mid number < last numnber
                basically just reverse the comparsion, same logic
        */
        
        if (nums == null || nums.length == 0) return -1;
        
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            
            if (nums[mid] == target) return mid;
            else if (nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else start = mid;
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
            
    }
}