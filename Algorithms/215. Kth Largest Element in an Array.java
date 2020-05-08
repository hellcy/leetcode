class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
            quick select 
            O(n) time
        */
        
        if (nums == null || nums.length == 0) return -1;
        return quickSelect(nums, 0, nums.length - 1, k);

        /*
            Priority Queue
                keep adding numbers to pq and removing the top numbers, so we only keep k greatest numbers in pq
                return the top number after we finished adding
                O(nlogn) time
        */
        // PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // for (int i : nums) {
        //     heap.add(i);
        //     if (heap.size() > k) {
        //         heap.poll();
        //     }
        // }
        
        // return heap.poll();
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];
        
        int pivot = nums[(end - start) / 2 + start];
        
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            
            while (left <= right && nums[right] < pivot) {
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
        
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        
        return nums[right + 1];
    }
}