/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        /*
            stack
            for each node, keep popping nodes to check if sum equals zero
            if not, add current node
            if yes, remove nodes
        */

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            int num = head.val;
            if (num == 0) {
                head = head.next;
                continue;
            }
            if (stack.isEmpty()) {
                stack.add(num);
            } else {
                int sum = num;
                Stack<Integer> temp = new Stack<>();
                boolean flag = false;
                while (!stack.isEmpty()) {
                    int cur = stack.pop();
                    sum += cur;
                    temp.add(cur);
                    if (sum == 0) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    while (!temp.isEmpty()) {
                        stack.add(temp.pop());
                    }
                    stack.add(num);
                }
            }
            head = head.next;
        }

        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }

        ListNode ans = new ListNode(0);
        ListNode current = ans;
        while (!temp.isEmpty()) {
            ListNode node = new ListNode(temp.pop());
            current.next = node;
            current = current.next;
        }
        return ans.next;
    }
}
// @lc code=end

