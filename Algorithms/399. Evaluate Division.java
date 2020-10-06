class Solution {
    double val = -1.0;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<Pair<String, String>, Double> map = new HashMap<>();
        
        int index = 0;
        for (List<String> list : equations) {
            Pair<String, String> pair = new Pair<>(list.get(0), list.get(1));
            Pair<String, String> pair2 = new Pair<>(list.get(1), list.get(0));
            map.put(pair, values[index]);
            map.put(pair2, 1.0 / values[index]);
            index++;
        }
        
        Map<String, Set<String>> graph = new HashMap<>();
        
        for (List<String> list : equations) {
            String start = list.get(0);
            String end = list.get(1);
            Set<String> set;
            Set<String> set2;
            if (!graph.containsKey(start)) {
                set = new HashSet<>();
                graph.put(start, set);
            } else {
                set = graph.get(start);
            }
            
            set.add(end);
            
            if (!graph.containsKey(end)) {
                set2 = new HashSet<>();
                graph.put(end, set2);
            } else {
                set2 = graph.get(end);
            }
            
            set2.add(start);
        }
        
        //System.out.println(graph);
                
        double[] ans = new double[queries.size()];
        index = 0;
        for (List<String> list : queries) {
            Set<String> visited = new HashSet<>();
            val = -1.0;
            String start = list.get(0);
            String end = list.get(1);
            
            dfs(start, end, graph, map, 1.0, visited);
            ans[index] = val;
            //System.out.println(val);
            index++;
        }
        
        return ans;
    }
    
    private void dfs(String start, String end, Map<String, Set<String>> graph, Map<Pair<String, String>, Double> map, double current, Set<String> visited) {
        if (val != -1.0) return;
        if (!graph.containsKey(start)) return;
        for (String str : graph.get(start)) {
            if (visited.contains(str)) continue;
            Pair<String, String> pair = new Pair<>(start, str);
            //System.out.println(start + " " + str);
            if (str.equals(end)) {
                val = current * map.get(pair);
                return;
            }
            if (map.containsKey(pair)) {
                //System.out.println(current * map.get(pair));
                visited.add(str);
                dfs(str, end, graph, map, current * map.get(pair), visited);
                visited.remove(str);
            }
        }
    }
}