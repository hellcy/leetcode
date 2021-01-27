/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        /*
            Note we can call parent node
            recursion
            Don't forget to set the parent pointers!!
        */
        
        if (leaf.parent == null) return leaf;
        helper(leaf, root);
        
        return leaf;
    }
    
    private void helper(Node node, Node root) {
        if (node == root) return;
        
        Node parent = node.parent;
        if (parent.left == node) parent.left = null;
        else parent.right = null;
        node.parent = null;

        helper(parent, root);
        if (node.left != null) {
            node.right = node.left;
        }
        node.left = parent;
        parent.parent = node;
    }
}