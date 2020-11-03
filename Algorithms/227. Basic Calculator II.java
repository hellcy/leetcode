/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int start = -1, end = -1;
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < cs.length; ++i) {
            if (!check(cs[i])) {
                if (start != -1) {
                    end = i;
                    int num = Integer.valueOf(s.substring(start, end));
                    stack.add(num);
                    start = -1;
                    end = -1;
                }
                if (cs[i] == ' ') continue;

                if (flag) {
                    int second = stack.pop();
                    int first = stack.pop();
                    Character op = stack2.pop();
                    int temp = 0;
                    if (op == '*') {
                        temp = first * second;
                    } else {
                        temp = first / second;
                    }
                    stack.add(temp);
                    flag = false;
                }

                stack2.add(cs[i]);
                if (cs[i] == '*' || cs[i] == '/') {
                    flag = true;
                }
            } else {
                if (start == -1) start = i;
            }
        }

        if (start != -1) {
            if (end == -1) stack.add(Integer.valueOf(s.substring(start)));
            else stack.add(Integer.valueOf(s.substring(start, end)));
        }

        if (flag) {
            int second = stack.pop();
            int first = stack.pop();
            Character op = stack2.pop();
            int temp = 0;
            if (op == '*') {
                temp = first * second;
            } else {
                temp = first / second;
            }
            stack.add(temp);
            flag = false;
        }

        //System.out.println(stack);
        //System.out.println(stack2);

        Stack<Integer> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        while (!stack.isEmpty()) {
            stack3.add(stack.pop());
        }
        while (!stack2.isEmpty()) {
            stack4.add(stack2.pop());
        }

        while (!stack4.isEmpty()) {
            int first = stack3.pop();
            int second = stack3.pop();
            Character op = stack4.pop();
            int temp = 0;
            if (op == '+') {
                temp = first + second;
            } else if (op == '-') {
                temp = first - second;
            }
            stack3.add(temp);
        }

        return stack3.pop();
    }

    private boolean check(char c) {
        return (c != '+'  && c != '-' && c != '*' && c != '/' && c != ' ');
    }
}
// @lc code=end

