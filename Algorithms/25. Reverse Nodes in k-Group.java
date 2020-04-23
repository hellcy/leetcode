/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1->2->3->4->5->6->7
        // 1->2->3->[6->5->4]->7
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverseNextKNode(prev, k);
        }
        
        return dummy.next;
    }
    
    // prev->n1->n2->n3->...->nk->nk+1
    // prev->nk->nk-1->...->n1->nk+1
    private ListNode reverseNextKNode(ListNode prev, int k) {
        int pos = 0;
        ListNode current = prev;
        ListNode n1 = prev.next;
        while (pos < k) {
            current = current.next;
            pos++;
            if (current == null) {
                return null;
            }
        }
        
        ListNode nk = current;
        ListNode next = nk.next;
        
        current = prev.next;
        ListNode pre = next;
        
        while (current != next) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        
        prev.next = nk;
        return n1;
    }
}