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
        int count = 0;
        boolean found = false;
        String prev = "";
        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];

            // not number
            if (c < 48 || c > 57) {
                if (tryAddNumber(stack, stack2, startnum, endnum, formula, found)) {
                    startnum = -1;
                }
                if (found) found = false;

            } else {
                if (startnum == -1) startnum = i;
                endnum = i + 1;
            }

            // not letters
            if (c < 65 || (c > 90 && c < 97) || c > 122) {
                if (tryAddName(stack, stack2, start, end, formula)) {
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
                }
                else if (c == ')') {
                    found = true;
                }
            }
        }

        tryAddNumber(stack, stack2, startnum, endnum, formula, found);
        tryAddName(stack, stack2, start, end, formula);


        //System.out.println(stack);
        //System.out.println(stack2);

        while (!stack.isEmpty() && !stack2.isEmpty()) {
            int num = stack2.pop();
            String key = stack.pop();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + num);
            } else {
                map.put(key, num);
            }
        }

        String ans = "";
        System.out.println(map);

        String[] array = new String[map.size()];

        int index = 0;
        for (String key : map.keySet()) {
            array[index] = key;
            index++;
        }

        Arrays.sort(array);

        for (String str : array) {
            int num = map.get(str);
            ans += str;
            if (num > 1) {
                ans += String.valueOf(num);
            }
        }

        return ans;
    }

    private boolean tryAddNumber(Stack<String> stack, Stack<Integer> stack2, int start, int end, String formula, boolean found) {
        if (start != -1) {
            int num = Integer.valueOf(formula.substring(start, end));
            if (found) {
                domultiply(stack, stack2, num);
            } else {
                stack2.add(num);
            }
            return true;
        } else {
            if (found) domultiply(stack, stack2, 1);
            return false;
        }
    }

    private boolean tryAddName(Stack<String> stack, Stack<Integer> stack2, int start, int end, String formula) {
        if (start != -1) {
            String str = formula.substring(start, end);
            stack.add(str);
            if (end >= formula.length()) stack2.add(1);
            else {
                char next = formula.charAt(end);
                if (next < 48 || next > 57) {
                    stack2.add(1);
                }
            }
            return true;
        } else return false;
    }

    private void domultiply(Stack<String> stack, Stack<Integer> stack2, int num) {
        System.out.println(stack);
        System.out.println(stack2);
        Stack<String> temp = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
            temp.add(stack.pop());
            temp2.add(num * stack2.pop());
        }
        
        if (stack.peek().equals("(")) stack.pop();

        while (!temp.isEmpty()) {
            stack.add(temp.pop());
            stack2.add(temp2.pop());
        }
    }
}
// @lc code=end

