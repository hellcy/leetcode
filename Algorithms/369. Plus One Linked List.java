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
    public ListNode plusOne(ListNode head) {
        /*
            recursion
            change node value from back to front
        */
        int num = helper(head);
        if (num == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            return node;
        } else {
            return head;
        }
    }

    private int helper(ListNode node) {
        int ret = 0;
        if (node.next == null) {
            node.val += 1;
            if (node.val >= 10) {
                node.val = 0;
                ret = 1;
            }
            return ret;
        } else {
            int num = helper(node.next);
            node.val += num;
            if (node.val >= 10) {
                node.val = 0;
                ret = 1;
            }
            return ret;
        }
    }
}