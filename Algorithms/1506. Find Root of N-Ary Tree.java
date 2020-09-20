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
    public Node findRoot(List<Node> tree) {
        /*
            Because all node have distinct value, we can store nodes indegree in a map
            root node has indegree zero
        */
        
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for (Node node : tree) {
            indegree.put(node.val, 0);
        }
        
        for (Node node : tree) {
            List<Node> list = node.children;
            
            for (Node cur : list) {
                indegree.put(cur.val, indegree.getOrDefault(cur.val, 0) + 1);
            }
        }
        
        
        int ans = 0;
        for (int i : indegree.keySet()) {
            if (indegree.get(i) == 0) ans = i;
        }
        
        for (Node node : tree) {
            if (node.val == ans) return node;
        }
        
        throw null;
    }
}