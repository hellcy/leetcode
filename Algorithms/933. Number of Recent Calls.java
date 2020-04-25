class RecentCounter {
    /*
        Queue
            Great question to understand queue structrue
    */
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        if (queue.peek() == null) {
            queue.add(t);
        } else {
            //System.out.println(queue);
            while (queue.peek() != null && queue.peek() + 3000 < t) {
                queue.poll();
            }
            queue.add(t);
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */