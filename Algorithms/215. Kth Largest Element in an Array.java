class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
            Priority Queue
                keep adding numbers to pq and removing the top numbers, so we only keep k greatest numbers in pq
                return the top number after we finished adding
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.poll();
    }
}