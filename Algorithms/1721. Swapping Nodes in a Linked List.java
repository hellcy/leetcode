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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int index = k;
        while (index > 1) {
        	cur = cur.next;
        	index--;
        }

        ListNode left = cur;
        cur = head;
        int n = 0;
        while (cur != null) {
        	n++;
        	cur = cur.next;
        }

        index = n - k + 1;
        cur = head;
        while (index > 1) {
        	cur = cur.next;
        	index--;
        }

        ListNode right = cur;
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }
}