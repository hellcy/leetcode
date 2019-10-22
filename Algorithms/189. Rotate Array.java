class Solution {
    public void rotate(int[] nums, int k) {
        /*
            Algorithm explained:
            rotate in-place with O(1) extra space and O(n*k) time complexity
            exchange the last element with its previous element, untill to the head of array
            doing this k rounds
        */
        // int temp;
        // for (int i = 0; i < k; ++i) {
        //     for (int j = nums.length - 1; j > 0; --j) {
        //         temp = nums[j];
        //         nums[j] = nums[j - 1];
        //         nums[j - 1] = temp;
        //     }
        // }
        
        /*
            Algorithm explained:
            reverse the entire array, then reverse the first to kth elements, then reverse the rest of the elements
            O(1) space and O(n) time complexity
        */
        // k %= nums.length;
        // reverse(nums, 0, nums.length - 1);
        // reverse(nums, 0, k - 1);
        // reverse(nums, k, nums.length - 1);

        /*
            Using another array
                deep copy the array
                the number at index i in the original array is placed at the index (i+ (length of array) - k)%(length of array). Then, we copy the new array to the original one
        */
        k = k % nums.length;
        
        int[] temp = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            temp[i] = nums[i];
        }
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = temp[(i + nums.length - k) % nums.length];
        }
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}