class Solution {
    public int findPeakElement(int[] nums) {
        /*
            Iterative Binary Search
        */
        // int low = 0;
        // int high = nums.length - 1;
        // while (low < high) {
        //     int mid = low + (high - low) / 2;
        //     if (nums[mid] > nums[mid + 1]) {
        //         high = mid;
        //     } else {
        //         low = mid + 1;
        //     }
        // }
        // return low;
        
        /*
            Recursive Binary Search
        */
        int low = 0;
        int high = nums.length - 1;
        return search(nums, low, high);
    }
    
    private int search(int[] nums, int low, int high) {
        if (low >= high) return low;
        int mid = low + (high - low) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, low, mid);
        } else {
            return search(nums, mid + 1, high);
        }
    }
}