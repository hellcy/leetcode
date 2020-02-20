class MovingAverage {
    /*
        Queue
            with fixed size
    */
    Queue<Integer> queue;
    int sizes;
    double total;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sizes = size;
        queue = new LinkedList<>();
        total = 0;
    }
    
    public double next(int val) {
        if (queue.size() == this.sizes) {
            total -= queue.poll();
        }
        queue.add(val);
        total += val;
        return total / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */