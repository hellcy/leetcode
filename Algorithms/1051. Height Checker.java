class Solution {
    public int heightChecker(int[] heights) {
        /*
            Algorithm explained:
                create a copy of the array
                sort the array
                check the differnece, count++ for each difference
        */
        int n = heights.length;
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = heights[i];
        }
        // insertion sort
        // int temp;
        // for (int i = 1; i < n; ++i) {
        //     for (int j = i; j > 0; --j) {
        //         if (heights[j] < heights[j - 1]) {
        //             temp = heights[j];
        //             heights[j] = heights[j - 1];
        //             heights[j - 1] = temp;
        //         }
        //     }
        // }
        
        // merge sort
        int start = 0;
        int end = n - 1;
        merge_sort(heights, start, end);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (heights[i] != array[i]) count++;
        }
        
        return count;
    }
    
    private void merge_sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            
            merge_sort(nums, start, mid);
            merge_sort(nums, mid + 1, end);
            
            merge(nums, start, mid, end);
        }
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int p = start, q = mid + 1, k = 0;
        int[] array = new int[end - start + 1];
        
        while (k < array.length) {
            if (p > mid) array[k++] = nums[q++];
            else if(q > end) array[k++] = nums[p++];
            else if(nums[p] < nums[q]) array[k++] = nums[p++];
            else array[k++] = nums[q++];
        }
        
        for (int i = 0; i < array.length; ++i) {
            nums[start++] = array[i];
        }
    }
}