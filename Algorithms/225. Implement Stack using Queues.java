class MyStack {
    /*
        everytime a new node come in, push it to the empty queue
        and then put everything in another queue into the first queue.
        that second queue become the empty queue in the next round
    */

    Queue<Integer> first;
    Queue<Integer> second;
    /** Initialize your data structure here. */
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (first.isEmpty()) {
            first.add(x);
            while (!second.isEmpty()) {
                first.add(second.poll());
            }
        } else {
            second.add(x);
            while (!first.isEmpty()) {
                second.add(first.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (first.isEmpty()) {
            return second.poll();
        } else {
            return first.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if (first.isEmpty()) {
            return second.peek();
        } else {
            return first.peek();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */