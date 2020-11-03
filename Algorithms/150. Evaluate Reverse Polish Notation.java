/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        /*
            Stack
        */

        Stack<Integer> stack = new Stack<>();
        
        for (String str : tokens) {
            if (isNumber(str)) {
                stack.add(Integer.valueOf(str));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                char c = str.charAt(0);
                int ans = 0;
                if (c == '+') {
                    ans = first + second;
                } else  if (c == '-') {
                    ans = first - second;
                } else if (c == '*') {
                    ans = first * second;
                } else {
                    ans = first / second;
                }
                stack.add(ans);
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String str) {
        if (str.length() == 1 && str.charAt(0) < 48) {
            return false;
        } else return true;
    }
}
// @lc code=end

