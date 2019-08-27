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
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == head) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            } 
        }
        
        if (fast == null || fast.next == null) return null;
        
        /* Algorithm explained: 
            set d = distance from head to the start of cycle
            set l = distance from start of cycle to the meet point in the cycle
            set h = distance from meet point to the start of cycle
            set s = distance from slow pointer travelled 
            
            we know fast pointer travelled 2s
            fast node could have travalled many round in the cycle waiting for slow pointer.
            
            s = d + l
            2s = d + l + n * (l + h)
            
            from above we can know: d = (n - 1)(l + h) + h
            
            by resetting fast node to head and make them travel at same speed, after (n - 1)(l + h) rounds of cycle
            fast pointer will have h distance to the start point of cycle, so as slow pointer, which now is at meet point
            so they will meet again at the start point of cycle. then return this node.
        */
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}