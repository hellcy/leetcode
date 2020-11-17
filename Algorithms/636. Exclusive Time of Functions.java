/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<String> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (String str : logs) {
            String[] arr = str.split(":");
            if (arr[1].equals("end")) {
                String[] start = stack.pop().split(":");
                int id = Integer.valueOf(start[0]);
                int time = Integer.valueOf(arr[2]) - Integer.valueOf(start[2]) + 1;
                stack2.pop();
                ans[id] += time;
                update(ans, stack2, time);
            } else {
                stack.add(str);
                stack2.add(Integer.valueOf(arr[0]));
            }
        }
        return ans;
    }

    private void update(int[] ans, Stack<Integer> stack, int time) {
        if (!stack.isEmpty()) {
            int id = stack.peek();
            ans[id] -= time;
        }
    }
}
// @lc code=end

