class Solution {
    public int findMin(int[] nums) {
        /*
            Binary Search
                There is a point in the array which 
                All the elements to the left of the point > first element of the array.
                All the elements to the right of the point < first element of the array.
                
                Find the mid element of the array.
                If mid element > first element of array this means that we need to look for the point on the right of mid.
                If mid element < first element of array this that we need to look for the point on the left of mid.
        */
        int low = 0;
        int high = nums.length - 1;
        
        // array is sorted
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[0]) {
                low = mid + 1;
            } else if (nums[mid] < nums[0]) {
                high = mid - 1;
            }
        }

        return nums[low];
    }
}