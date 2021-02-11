class MRUQueue {
    /*
        move the MRU element to the end of queue
    */
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    boolean isMainQueue1;
    public MRUQueue(int n) {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            queue1.add(i);
        }
        isMainQueue1 = true;
    }
    
    public int fetch(int k) {
        if (isMainQueue1) {
            isMainQueue1 = !isMainQueue1;
            return helper(k, queue1, queue2);
        } else  {
            isMainQueue1 = !isMainQueue1;
            return helper(k, queue2, queue1);
        }
    }

    private int helper(int k, Queue<Integer> main, Queue<Integer> queue) {
        while (k > 1) {
            queue.add(main.poll());
            k--;
        }
        int val = main.poll();
        while (!main.isEmpty()) {
            queue.add(main.poll());
        }

        queue.add(val);
        return val;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */