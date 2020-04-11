class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
            1. create the graph
            2. find degress for each node
            3. find startnodes, startnodes are the nodes with 0 degree. Meaning we don't need any prerequisites to take these course
            4. BFS the graph and see if we have visited the entire graph (list size == numCourses)
        */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < prerequisites.length; ++i) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Map<Integer, Integer> degrees = new HashMap<>();
        
        for (int i = 0; i < numCourses; ++i) {
            degrees.put(i, 0);
        }
        
        for (int i = 0; i < prerequisites.length; ++i) {
            degrees.put(prerequisites[i][0], degrees.get(prerequisites[i][0]) + 1);
        }
        
        List<Integer> startnodes = new ArrayList<>();
        
        for (int node : degrees.keySet()) {
            if (degrees.get(node) == 0) {
                startnodes.add(node);
            }
        }
        
        if (startnodes.size() == 0) return false;
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i : startnodes) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);
            
            for (int neighbor : graph.get(current)) {
                degrees.put(neighbor, degrees.get(neighbor) - 1);
                if (degrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if (ans.size() == numCourses) return true;
        else return false;
    }
}