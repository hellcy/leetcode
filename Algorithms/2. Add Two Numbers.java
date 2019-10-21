/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> list = new LinkedList<>(); 
        ListNode result = null;
        ListNode current1 = l1;
        ListNode current2 = l2;
        int length1 = 0;
        int length2 = 0;
        while (current1 != null) {
            length1++;
            current1 = current1.next;
        }
        
        while (current2 != null) {
            length2++;
            current2 = current2.next;
        }
        
        if (length1 >= length2) result = add(l1, l2, l1);
        else result = add(l1, l2, l2);
        
        return result;
    }
    
    private ListNode add(ListNode current1, ListNode current2, ListNode result) {
        int carry = 0;
        ListNode finalCarry = new ListNode(1);
        ListNode head = result;
        while (current1 != null && current2 != null) {
            if ((current1.val + current2.val + carry) >= 10) {
                result.val = current1.val + current2.val - 10 + carry;
                carry = 1;
            } else {
                result.val = current1.val + current2.val + carry;
                carry = 0;
            }
            
            if (result.next == null && carry == 1) {
                result.next = finalCarry;
                carry = 0;
                break;
            }
            
            result = result.next;
            current1 = current1.next;
            current2 = current2.next;
        }
        
        if (carry == 1) {
            while (result != null) {
                if ((result.val + carry) >= 10) {
                    result.val = result.val + carry - 10;
                    carry = 1;
                } else {
                    result.val += carry;
                    carry = 0;
                }
                
                if (result.next == null && carry == 1) {
                    result.next = finalCarry;
                    break;
                }
                result = result.next;
            }
        }
        return head;
    }
}