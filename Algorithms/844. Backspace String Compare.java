class Solution {
    public boolean backspaceCompare(String S, String T) {
        /*
            Stack
        */
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        char[] ss = S.toCharArray();
        char[] ts = T.toCharArray();
        
        for (char c : ss) {
            if (c != '#') {
                stack1.push(c);
            } else if (!stack1.empty()) {
                stack1.pop();
            }
        }
        
        for (char c : ts) {
            if (c != '#') {
                stack2.push(c);
            } else if (!stack2.empty()) {
                stack2.pop();
            }
        }
        
        //System.out.println(stack1.size());
        if (stack1.size() != stack2.size()) return false;
        while (!stack1.empty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }
        
        return true;
    }
}