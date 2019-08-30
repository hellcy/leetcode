/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /* 
            create two pointers running at different speed
            they will finally meet each other if there is a cycle in the list
        */
        if (head == null) return false;
        ListNode a = head;
        ListNode b = head;
        
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) return true;
        }
        return false;
    }
}