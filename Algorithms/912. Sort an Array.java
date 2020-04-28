class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {};
        /*
            Merge sort
        */
        
        // int[] array = new int[nums.length];
        // mergesort(nums, array, 0, nums.length - 1);
        
        /*
            Quick sort
        */
        quicksort(nums, 0, nums.length - 1);
        
        return nums;
    }
    
    private void mergesort(int[] nums, int[] array, int start, int end) {
        if (start >= end) return;
        
        int mid = (end - start) / 2 + start;
        
        mergesort(nums, array, start, mid);
        mergesort(nums, array, mid + 1, end);
        
        merge(nums, array, start, mid, end);
    }
    
    private void merge(int[] nums, int[] array, int start, int mid, int end) {
        int left = start, right = mid + 1;
        int index = start;
        
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                array[index++] = nums[left++];
            } else {
                array[index++] = nums[right++];
            }
        }
        
        while (left <= mid) {
            array[index++] = nums[left++];
        }
        
        while (right <= end) {
            array[index++] = nums[right++];
        }
        
        for (index = start; index <= end; ++index) {
            nums[index] = array[index];
        }
    }
    
    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) return;
        
        // note: here we need to save the pivot value, not index
        // because nums[index] may be change during the loop. So pivot value may be changed if we only saved index
        int pivot = nums[(end - start) / 2 + start];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        quicksort(nums, start, right);
        quicksort(nums, left, end);
    }
}