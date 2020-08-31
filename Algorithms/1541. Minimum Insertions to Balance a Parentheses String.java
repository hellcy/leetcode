class Solution {
    public int minInsertions(String s) {
        /*
            Stack
        */
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(c);
            } else {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == ')') {
                         if (stack.isEmpty()) count++;
                        else stack.pop();
                        i++;
                    } else {
                        if (stack.isEmpty()) count += 2;
                        else {
                            stack.pop();
                            count++;
                        }
                    }
                } else {
                    if (stack.isEmpty()) count += 2;
                    else {
                        stack.pop();
                        count++;
                    }
                }
            }
        }
        int size = stack.size();
        count += size * 2;
        return count;
    }
}