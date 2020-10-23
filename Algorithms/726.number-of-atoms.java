/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 */

// @lc code=start
class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();

        Stack<String> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        char[] cs = formula.toCharArray();

        int start = -1, end = -1;
        int startnum = -1, endnum = -1;
        int depth = 0;
        String prev = "";
        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];

            if (c < 48 || c > 57) {
                if (tryAddNumber(stack2, startnum, endnum, formula)) {
                    startnum = -1;
                }
            }

            if (c < 65 || (c > 90 && c < 97) || c > 122) {
                if (tryAddName(stack, start, end, formula)) {
                    char next = formula.charAt(end);
                    if (next < 48 || next > 57) {
                        stack2.add(1);
                    }
                    start = -1;
                }
            }

            if (c >= 65 && c <= 90) {
                if (start != -1) {
                    stack.add(formula.substring(start, end));
                    char next = formula.charAt(end);
                    if (next < 48 || next > 57) {
                        stack2.add(1);
                    }
                }
                start = i;
                end = i + 1;
            } else if (c >= 97) {
                end = i + 1;
            } else {
                if (c == '(') {
                    stack.add("(");
                    depth++;
                }
                else if (c == ')') {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        String str = stack.pop();
                    }
                    depth--;
                }
                else {
                    if (startnum == -1) startnum = i;
                    endnum = i + 1;
                }
            }
        }

        System.out.println(stack);
        System.out.println(stack2);

        return "";
    }

    private boolean tryAddNumber(Stack<Integer> stack, int start, int end, String formula) {
        if (start != -1) {
            int num = Integer.valueOf(formula.substring(start, end));
            stack.add(num);
            return true;
        }
        else return false;
    }

    private boolean tryAddName(Stack<String> stack, int start, int end, String formula) {
        if (start != -1) {
            String str = formula.substring(start, end);
            stack.add(str);
            return true;
        } else return false;
    }
}
// @lc code=end

