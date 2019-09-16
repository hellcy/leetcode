class KthLargest {
    /*
        Priority Queue with Contructor
    */
    private int k;
    private PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>((x, y) -> x - y);
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */