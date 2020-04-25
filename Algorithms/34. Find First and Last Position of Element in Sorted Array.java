class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
            Binary Search
                The third template of binary search
                we need accessing the current index and its immediate left and right neighbor's index in the array.
                first find the first occurance of the target number,
                then find the last occurance of the target number, so we have the range
        */
        if (nums.length < 1) return new int[] {-1, -1};
        if (nums.length == 1 && target != nums[0]) return new int[] {-1, -1};
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            //System.out.println(nums[mid] + " " + mid);
            if (nums[mid - 1] >= target) {
                high = mid;
            } else if (nums[mid + 1] <= target) {
                low = mid;
            } else {
                if (nums[mid] == target) return new int[] {mid, mid};
                else return new int[] {-1, -1};
            }
        }
        
        /* 
            filter out corner cases
                1. target number is the first number
                2. target number is the last number
                3. target number doesn't exist in the array
        */
        if (low == 0 && nums[low] != nums[high] && nums[low] == target) return new int[] {low, low};
        else if (high == nums.length - 1 && nums[low] != nums[high] && nums[high] == target) return new int[] {high, high};
        else if ((low == 0 && nums[low] != target) || (high == nums.length - 1 && target != nums[high])) return new int[] {-1, -1};
        
        int start = low;
        low = 0;
        high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            //System.out.println(nums[mid] + " " + mid);
            if (nums[mid + 1] <= target) {
                low = mid;
            } else if (nums[mid - 1] >= target) {
                high = mid;
            }
        }
        
        int end = high;
        
        return new int[] {start, end};
    }
}