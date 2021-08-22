class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                Set<Integer> set = new HashSet<>();
                map.put(edge[0], set);
            }
            if (!map.containsKey(edge[1])) {
                Set<Integer> set = new HashSet<>();
                map.put(edge[1], set);
            }
            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            
        }
        
        //System.out.println(map);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        if (!map.containsKey(start)) return false;
        for (int current : map.get(start)) {
            queue.add(current);
        }
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) return true;
            for (int i : map.get(current)) {
                if (visited.contains(i)) continue;
                queue.add(i);
            }
            visited.add(current);
        }
        
        return false;
    }
}