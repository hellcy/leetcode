class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
            1. create the graph
            2. find the indegrees for all nodes
            3. find the start nodes, which are the nodes with indegrees == 0, if no nodes with indegree == 0, we can't finish a course
            4. BFS the graph, if list of nodes visited != numCourses, we can't finish all courses
            5. return the list
        */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < prerequisites.length; ++i) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Map<Integer, Integer> indegrees = new HashMap<>();
        
        for (int i = 0; i < numCourses; ++i) {
            indegrees.put(i, 0);
        }
        
        for (int i = 0; i < prerequisites.length; ++i) {
            indegrees.put(prerequisites[i][0], indegrees.get(prerequisites[i][0]) + 1);
        }
        
        List<Integer> startnodes = new ArrayList<>();
        
        for (int node : indegrees.keySet()) {
            if (indegrees.get(node) == 0) {
                startnodes.add(node);
            }
        }
        
        if (startnodes.size() == 0) return new int[] {};
        
        List<Integer> ans = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int node : startnodes) {
            queue.add(node);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);
            
            for (int neighbor : graph.get(current)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if (ans.size() != numCourses) return new int[] {};
        
        int[] array = new int[ans.size()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = ans.get(i);
        }

        return array;
    }
}