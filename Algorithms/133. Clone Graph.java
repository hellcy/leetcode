/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
        Deep copy a graph
        1. BFS traverse all nodes in the graph, store it in a List
        2. Find all mapping relationships between new nodes and original nodes.
        3. Copy each edges for all new nodes

        Note: step2 is very important. See wrong answer in the comment below. We cannot just create new neighbors with the same value. Neighbors has to be in the graph
        If we create new neighbors. All neighbors will be different. Graph is not the same
    */
    public Node cloneGraph(Node node) {        
        if (node == null) return null;
        List<Node> nodes = getNodes(node);
        
        // Attention to the wrong answer below!!
        // wrong answer, need to use a hashmap to store all mapping relationships between new node and original node.
        // this way we create new node for every neighbor, even though the values are the same. but these neighbors are new nodes 
        // not the real neighbors in the graph.
        // Node ans = null;
        // for (Node n : nodes) {
        //     Node newnode = new Node(n.val);
        //     for (Node neighbor : n.neighbors) {
        //         Node newneighbor = new Node(neighbor.val);
        //         newnode.neighbors.add(newneighbor);
        //     }
        //     if (n == node) ans = newnode;
        // }
        // return ans;
        Map<Node, Node> map = new HashMap<>();
        
        for (Node n : nodes) {
            map.put(n, new Node(n.val));
        }
        
        for (Node n : nodes) {
            Node newnode = map.get(n);
            for (Node neighbor : n.neighbors) {
                Node newneighbor = map.get(neighbor);
                newnode.neighbors.add(newneighbor);
            }
        }
        
        return map.get(node);
    }
    
    private List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            
            for (Node neighbor : n.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
            }
        }
        
        return new ArrayList<Node>(set);
    }
}