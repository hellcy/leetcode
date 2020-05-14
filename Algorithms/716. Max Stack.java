class MaxStack {
    /*
        Two Stacks and a buffer stack
    */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        // do intialization if necessary
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */    
    public void push(int x) {
        // write your code here
        stack.push(x);
        if (!maxStack.empty()) {
            Stack<Integer> temp = new Stack<>();
            while (!maxStack.empty() && maxStack.peek() > x) {
                temp.push(maxStack.pop());
            }
            maxStack.push(x);
            while (!temp.empty()) {
                maxStack.push(temp.pop());
            }
        } else {
            maxStack.push(x);
            
        }
    }

    public int pop() {
        // write your code here
        int number = stack.pop();
        Stack<Integer> temp = new Stack<>();
        while (maxStack.peek() != number) {
            temp.push(maxStack.pop());
        }
        
        maxStack.pop();
        while (!temp.empty()) {
            maxStack.push(temp.pop());
        }
        
        return number;
    }

    /*
     * @return: An integer
     */    
    public int top() {
        // write your code here
        return stack.peek();
    }

    /*
     * @return: An integer
     */    
    public int peekMax() {
        // write your code here
        return maxStack.peek();
    }

    /*
     * @return: An integer
     */    
    public int popMax() {
        // write your code here
        int number = maxStack.pop();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != number) {
            temp.push(stack.pop());
        }
        
        stack.pop();
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
        
        return number;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */