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
    public ListNode oddEvenList(ListNode head) {
        /*
            LinkedList
            Brute force
        */
        if (head == null || head.next == null) return head;
        ListNode oddhead = head;
        ListNode evenhead = head.next;
        
        ListNode currentodd = oddhead;
        ListNode currenteven = evenhead;
        while (currentodd != null && currenteven != null && currenteven.next != null) {
            currentodd.next = currenteven.next;
            currentodd = currentodd.next;
            currenteven.next = currentodd.next;
            currenteven = currenteven.next;
        }
        
        currentodd.next = evenhead;
        return oddhead;
    }
}