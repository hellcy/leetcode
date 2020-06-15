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
    /*
        Linked List
    */
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode current = new ListNode(-1);
        current.next = head;
        while (current != null && current.next != null) {
            int count = m;
            while (current != null && current.next != null && count > 0) {
                current = current.next;
                count--;
                //System.out.println(current.val);
            }
            count = n;
            while (current.next != null && count > 0) {
                current.next = current.next.next;
                count--;

            }
        }
        
        return head;
    }
}