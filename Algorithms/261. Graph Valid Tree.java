class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*
            a valid tree has following two conditions
            1. N nodes has N - 1 edges
            2. All nodes are connected
        */
        
        if (n == 0) return true;
        if (edges.length != n - 1) return false;
        
        Map<Integer, Set<Integer>> graph = newgraph(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        queue.add(0);
        set.add(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int i : graph.get(node)) {
                if (!set.contains(i)) {
                    queue.add(i);
                    set.add(i);
                }
            }
        }
        
        if (set.size() == n) return true;
        else return false;
    }
    
    private Map<Integer, Set<Integer>> newgraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; ++i) {
            // note: edges are bi-directional
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        return graph;
    }
}