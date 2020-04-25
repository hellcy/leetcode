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
        N-ary PostOrder Traversal Recursion
    */
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        
        helper(root);
        return list;
    }
    
    private void helper(Node node) {
        for (Node current : node.children) {
            helper(current);
        }
        list.add(node.val);
    }
}