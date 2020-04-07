/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    /*
        In order traverse and construct it to a circular doubly linked list
    */
    List<Integer> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        helper(root);
        Node head = new Node(list.get(0));
        Node prev = head;
        for (int i = 1; i < list.size(); ++i) {
            Node node = new Node(list.get(i));
            node.left = prev;
            //System.out.println(node.val);
            prev.right = node;
            prev = prev.right;

        }
        prev.right = head;
        head.left = prev;
        return head; 
    }
    
    private void helper(Node node) {
        if (node.left != null) {
            helper(node.left);
        }
        list.add(node.val);
        
        if (node.right != null) {
            helper(node.right);
        }
    }
}