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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode prev;
        
        while (current != null && current.next != null) {
            prev = current;
            current = current.next;
            if (current.val < prev.val) {
                ListNode node = current;
                prev.next = node.next;
                
                ListNode target = dummy;
                ListNode targetprev;
                while (target.next != null) {
                    targetprev = target;
                    target = target.next;
                    if (node.val <= target.val) {
                        node.next = target;
                        targetprev.next = node;
                        break;
                    }
                }
            }
        }
        
        return dummy.next;
    }
}