class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        /*
            Graph
            1. get adjcent list
            2. get indegree
            3. for each pair of nodes, calculate total indegrees and minus 1 if they are connected
        */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            Set<Integer> list = new HashSet<>();
            graph.put(i, list);
            
            indegrees.put(i, 0);
        }
        
        for (int[] road : roads) {
            int first = road[0];
            int second = road[1];
            graph.get(first).add(second);
            graph.get(second).add(first);
            
            indegrees.put(first, indegrees.get(first) + 1);
            indegrees.put(second, indegrees.get(second) + 1);
        }
        
        int ans = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int total = indegrees.get(i) + indegrees.get(j);
                if (graph.get(i).contains(j)) total--;
                
                ans = Math.max(ans, total);
            }
        }
        
        
        return ans;
    }
}