class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        char[] cs = s.toCharArray();
        
        int index = 0, start = 0;
        boolean isChar = true, after = false;
        for (char c : cs) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                if (after) {
                    stack2.add(stack2.pop() + s.substring(start, index));
                    after = false;
                    start = index;
                }
                else if (isChar) {
                    stack2.add(s.substring(start, index));
                    start = index;
                }
                isChar = false;
            } else if (c >= 'a' && c <= 'z') {
                
            } else if (c == '[') {
                stack.add(Integer.valueOf(s.substring(start, index)));
                start = index + 1;
                isChar = true;
            } else {
                if (after) {
                    stack2.add(stack2.pop() + s.substring(start, index));
                    after = false;
                } else {
                    stack2.add(s.substring(start, index));
                }
                
                
                String temp = stack2.pop();
                String str = "";
                int num = stack.pop();
                for (int i = 0; i < num; ++i) {
                    str += temp;
                }
                if (!stack2.isEmpty()) {
                    String prev = stack2.pop();
                    str = prev + str;
                }
                stack2.add(str);   
                after = true;
                start = index + 1;
            }
            
            index++;
        }
        
        if (after) {
            stack2.add(stack2.pop() + s.substring(start, index));
        }
        if (stack2.isEmpty()) return s;
        return stack2.pop();
    }
}