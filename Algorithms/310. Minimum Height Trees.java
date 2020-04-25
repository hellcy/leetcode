class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /*
            BFS
            Indegrees
                1. create a graph based on edges given
                2. the answer can either be 1 or 2
                3. use the indegrees to peel of the leaf nodes level by level until remaining nodes are less or equal to 2
                4. return the remaining nodes
        */
        List<Integer> list = new ArrayList<>();
        
        if (n == 0) return list;
        
        Map<Integer, Set<Integer>> graph = getGraph(n, edges);
        
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            indegrees.put(i, 0);
        }
        
        for (int i = 0; i < edges.length; ++i) {
            indegrees.put(edges[i][0], indegrees.get(edges[i][0]) + 1);
            indegrees.put(edges[i][1], indegrees.get(edges[i][1]) + 1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int node : indegrees.keySet()) {
            if (indegrees.get(node) <= 1) {
                queue.add(node);
                visited.add(node);
            }
        }
        
        while (n > 2) {
            int size = queue.size();
            n = n  - size;
            for (int i = 0; i < size; ++i) {
                int current = queue.poll();
                
                for (int neighbor : graph.get(current)) {
                    indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                    if (!visited.contains(neighbor)) {
                        
                        if (indegrees.get(neighbor) <= 1) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        
        return list;
    }
    
    private Map<Integer, Set<Integer>> getGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < edges.length; ++i) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        return graph;
    }
}