class Solution {
    public boolean isValid(String s) {
        /*
            Stack
        */
        Stack<Character> stack = new Stack<>();
        
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char temp = s.charAt(i);
            if (stack.empty()) {
                stack.push(temp);
            } else if (stack.peek() == '(' && temp == ')') {
                stack.pop();
            } else if (stack.peek() == '{' && temp == '}') {
                stack.pop();
            } else if (stack.peek() == '[' && temp == ']') {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }
        if (!stack.empty()) return false;
        else return true;
    }
}