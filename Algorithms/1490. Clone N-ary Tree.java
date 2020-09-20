/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if (root == null) return root;
        
        Node r = new Node();
        helper(root, r);
        return r;
    }
    
    private void helper(Node node, Node copy) {
        copy.val = node.val;
        List<Node> list = new ArrayList<>();
        copy.children = list;
        for (Node n : node.children) {
            Node cur = new Node();
            list.add(cur);
            helper(n, cur);
        }
    }
}