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
    int max = 0;
    public int diameter(Node root) {
        /*
            DFS
        */
        helper(root);
        
        return max;
    }
    
    private int helper(Node node) {
        int first = 0, second = 0;
        if (node == null) return 0 ;
        if (node.children.size() == 0) {
            return 1;
        }
        for (Node current : node.children) {
            int val = helper(current);
            //System.out.println(current.val + " " + val);
            if (val > first) {
                second = first;
                first = val;
            } else if (val > second) {
                second = val;
            }
        }
        
        max = Math.max(max, first + second);
        return first + 1;
    }
}