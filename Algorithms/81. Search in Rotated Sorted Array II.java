class Solution {
    public boolean search(int[] nums, int target) {
        /*
            Binary search
            same as rotate sorted array 1. But everytime we find nums[mid], we check if nums[start] or nums[end] equals nums[mid]
            move start and end towards the center until they are not the same, so we get rid of the duplicates
        */
        if (nums.length == 0) return false;
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            
            if (nums[mid] == target) return true;
            while (end > mid && nums[mid] == nums[end]) end--;
            while (start < mid && nums[mid] == nums[start]) start++;
            
            // same as rotated sorted array 1
            if (nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        //System.out.println(start + " " + end);
        if (nums[start] != target && nums[end] != target) return false;
        else return true;
    }
}