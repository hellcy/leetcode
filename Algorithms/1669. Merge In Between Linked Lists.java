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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode current1 = head;
        int index = 0;
        while (index < a - 1) {
            current1 = current1.next;
            index++;
        }
        
        ListNode start = current1;
        while (index <= b) {
            current1 = current1.next;
            index++;
        }
        ListNode end = current1;
        ListNode head2 = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        
        start.next = head2;
        list2.next = end;
        return head;
    }
}