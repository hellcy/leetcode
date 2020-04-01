class MyCircularQueue {
    /*
        we may use a fixed-size array and two pointers to indicate the starting position and the ending position.
        https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1396/
        when dequeue, start pointer move to the next position
        when enqueue, end pointer move to the next position
        when either pointer reaches the end of the array, go back to the head
    */
    int[] array;
    int start, end, size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k];
        start = -1;
        end = -1;
        size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //System.out.println(start + " " + end);
        if (isFull()) return false;
        end = (end + 1) % size;
        array[end] = value;
        
        if (start == -1) start = end;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (start == -1) return false;
        else if (start == end) {
            start = -1;
            end = -1;
            return true;
        }
        else {
            start = (start + 1) % size;
            return true;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (start == -1) return -1;
        return array[start];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (start == -1) return -1;
        return array[end];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return start == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (Math.abs(start - end) + 1 >= size || start - end == 1);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */