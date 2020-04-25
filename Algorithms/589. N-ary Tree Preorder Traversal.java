/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    /*
        N-ary Tree PreOrder Traversal Recursion
    */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        
        helper(root);
        return list;
    }
    
    private void helper(Node node) {
        list.add(node.val);
        for (Node current : node.children) {
            helper(current);
        }
    }
}