class Solution {
    public int findPairs(int[] nums, int k) {
        /*
            Algorithm explained:
                create two pointers, fast and slow
                sort the array first
                count only increment when 
                    their absolute differnece is k, 
                    and at least one of their value haven't appear before, 
                    and their are not equal
                otherwise 
                    increment the smaller one when difference greater than k
                    increment the bigger one when difference less than k
        */
        
        // insertion sort
        // int temp;
        // for (int i = 1; i < nums.length; ++i) {
        //     for (int j = i; j > 0; --j) {
        //         if (nums[j] < nums[j  -1]) {
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
        
        Set<Integer> set = new HashSet<>();
        
        int slow = 0;
        int fast = 0;
        int count = 0;
        while (fast < nums.length && slow < nums.length) {
            if (nums[fast] - nums[slow] < k) {
                fast++;
            } else if (Math.abs(nums[fast] - nums[slow]) == k && !set.contains(nums[slow]) && slow != fast) {
                set.add(nums[slow]);
                count++;
                slow++;
                fast++;
            } else {
                slow++;
            }
        }
        return count;
    }
    
    private void merge_sort(int[] nums, int start, int end) { 
        if (start < end) 
        {
            int mid = (start + end) / 2;
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