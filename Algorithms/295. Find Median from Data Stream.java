class MedianFinder {
    /*
        heap
        创建两个heap, left and right
        维护他们保证他们的size相差不过1，右边的size永远大于等于左边
        维护一个median, 当总数量为偶数时,将它与右边的最小值相加除以2就是答案
        否则median就是答案
        Time O(nlogn)
        Space O(n)
    */
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int size = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((x, y) -> y - x);
        right = new PriorityQueue<>((x, y) -> x - y);
    }
    
    public void addNum(int num) {
        right.add(num);
        if (size % 2 == 0) {
            if (left.isEmpty()) {
                size++;
                return;
            } else if (left.peek() > right.peek()) {
                int leftnum = left.poll();
                int rightnum = right.poll();
                left.add(rightnum);
                right.add(leftnum);
            }
        } else {
            left.add(right.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if (size % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0; 
        } else return right.peek() / 1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */