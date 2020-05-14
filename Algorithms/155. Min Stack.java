class MinStack {
    /*
        Two Stacks
            Normal stack
            Min stack, only insert values if it smaller then the current peek value
            When pop, only pop value from min stack if it equals to the min stack peek value
    */
    Stack<Integer> stack;
    Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minstack.empty()) {
            minstack.push(x);
        } else {
            if (minstack.peek() >= x) {
                minstack.push(x);
            }
        }
    }
    
    public void pop() {
        int number = stack.pop();
        if (minstack.peek() == number) minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */