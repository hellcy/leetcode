/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*
            Similar to clone graph
            1. we need to find the mapping relationship between the old node and the new node
            2. add pointers for each new node
            
            Note: See Clone graph for more information
        */
        
        Map<Node, Node> map = new HashMap<>();
        
        Node dummy = new Node(0);
        dummy.next = head;
        
        while (head != null) {
            Node newnode = new Node(head.val);
            map.put(head, newnode);
            head = head.next;
        }
        
        head = dummy.next;
        while (head != null) {
            Node newnode = map.get(head);
            newnode.next = map.get(head.next);
            newnode.random = map.get(head.random);
            head = head.next;
        }
        
        return map.get(dummy.next);
    }
}