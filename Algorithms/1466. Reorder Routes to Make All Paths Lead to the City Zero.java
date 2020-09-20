class Solution {
    public int minReorder(int n, int[][] connections) {
        /*
            Graph
        */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> ungraph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            graph.put(i, set);
            ungraph.put(i, set2);
        }
        
        for (int i = 0; i < connections.length; ++i) {
            graph.get(connections[i][0]).add(connections[i][1]);
            ungraph.get(connections[i][0]).add(connections[i][1]);
            ungraph.get(connections[i][1]).add(connections[i][0]);
        }
                
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        
        int ans = 0;
        Set<Integer> tozero = new HashSet<>();
        tozero.add(0);
        
        
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);
            for (int neighbor : ungraph.get(current)) {
                if (visited.contains(neighbor)) continue;
                if (graph.get(current).contains(neighbor)) ans++;
                queue.add(neighbor);
            }
            
            
        }
        
        return ans;
    }
}