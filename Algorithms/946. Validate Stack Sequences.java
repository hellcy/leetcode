class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /*
            Stack
        */
        Stack<Integer> stack = new Stack<>();
        
        int length = pushed.length;
        int current = 0;
        
        for (int i = 0; i < length; ++i) {
            while (stack.empty() || stack.peek() != popped[i]) {
                if (current == length) return false;
                stack.push(pushed[current++]);
                //System.out.println(stack);
            }
            stack.pop();
        }
        
        return true;
    }
}