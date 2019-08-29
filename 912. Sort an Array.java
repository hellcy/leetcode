class Solution {
    public int[] sortArray(int[] nums) {
        // insertion sort
        // int temp;
        // for (int i = 1; i < nums.length; ++i) {
        //     for (int j = i; j > 0; --j) {
        //         if (nums[j] < nums[j - 1]) {
        //             temp = nums[j];
        //             nums[j] = nums[j - 1];
        //             nums[j - 1] = temp;
        //         }
        //     }
        // }
        
        // merge sort
        int start = 0;
        int end = nums.length - 1;
        merge_sort(nums, start, end);
        return nums;
    }
    
    private void merge_sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            merge_sort(nums, start, mid);
            merge_sort(nums, mid + 1, end);
            
            merge(nums, start, mid, end);
        }
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int[] array = new int[end - start + 1];
        int p = start, q = mid + 1, k = 0;
        for (int i = 0; i < array.length; ++i) {
            if (p > mid) array[k++] = nums[q++];
            else if (q > end) array[k++] = nums[p++];
            else if (nums[p] < nums[q]) array[k++] = nums[p++];
            else array[k++] = nums[q++];
        }
        
        for (int i = 0; i < array.length; ++i) {
            nums[start++] = array[i];
        }
    }
}