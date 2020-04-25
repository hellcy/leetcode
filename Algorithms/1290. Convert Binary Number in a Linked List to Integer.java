/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        Stack
        Linked List
    */
    public int getDecimalValue(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        
        int result = 0;
        int count = 0;
        while (!stack.isEmpty()) {
            result += Math.pow(2, count) * stack.pop();
            count++;
            //System.out.println(result);
        }
        
        return result;
    }
}