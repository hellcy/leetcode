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
        Binary tree top down
    */
    int depth = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        
        helper(root, 1);
        return depth;
    }
    
    private void helper(Node node, int level) {
        if (node.children.size() == 0) {
            if (level > depth) {
                depth = level;
            }
        } else {
            for (Node cur : node.children) {
                helper(cur, level + 1);
            }
        }
    }
}