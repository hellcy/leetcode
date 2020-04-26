/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
            Priority Queue
            O(NlogK)
            store list heads into a priorityQueue
            get the smallest ListNode from k list heads, add head.next to the heap
            takes O(logk) to perform pq add and poll
        */
        
        // if (lists == null || lists.length == 0) return null;
        
        // PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (x, y) -> x.val - y.val);
        
        // for (int i = 0; i < lists.length; ++i) {
        //     if (lists[i] != null) {
        //         heap.add(lists[i]);
        //     }
        // }
        
        
        // ListNode dummy = new ListNode(0);
        // ListNode tail = dummy;
        
        // while (!heap.isEmpty()) {
        //     ListNode head = heap.poll();
        //     tail.next = head;
        //     tail = head;
            
        //     if (head.next != null) {
        //         heap.add(head.next);
        //     }
        // }
        
        // return dummy.next;
        /*
            Merge sort
            Use queue to store sorted list until there is only one list left in the queue
            O(NlogK)
        */
//         Queue<ListNode> queue = new LinkedList<>();
//         for (ListNode node : lists) {
//             queue.add(node);
//         }
        
//         while (queue.size() > 1) {
//             ListNode head1 = queue.poll();
//             ListNode head2 = queue.poll();
            
//             queue.add(merge(head1, head2));
//         }
        
//         return queue.poll();

        /*
            Merge Sort
            Divide and conquer
            O(NlogK)
        */
        if (lists == null || lists.length == 0) return null;

        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];

        int mid = (end - start) / 2 + start;

        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);

        return merge(left, right);
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            
            tail = tail.next;
        }
        
        if (head1 != null) tail.next = head1;
        else tail.next = head2;
        
        return dummy.next;
    }
}