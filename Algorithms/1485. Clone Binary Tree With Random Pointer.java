/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        /*
            1. Use a Map to store the link between node and copy
            2. Traverse again to store left, right and random pointers 
        */
        if (root == null) return null;
        
        Map<Node, NodeCopy> map = new HashMap<>();
        
        helper(root, map);
        
        helper2(root, map);
        
        return map.get(root);
    }
    
    private void helper(Node node, Map<Node, NodeCopy> map) {
        NodeCopy copy = new NodeCopy(node.val);
        map.put(node, copy);
        
        if (node.left != null) helper(node.left, map);
        if (node.right != null) helper(node.right, map);
    }
    
    private void helper2(Node node, Map<Node, NodeCopy> map) {
        NodeCopy copy = map.get(node);
        copy.left = map.get(node.left);
        copy.right = map.get(node.right);
        copy.random = map.get(node.random);
        
        if (node.left != null) helper2(node.left, map);
        if (node.right != null) helper2(node.right, map);
    }
}