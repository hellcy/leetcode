/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /*
            DFS
        */

        List<List<Integer>> lists = new ArrayList<>();

        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for (int i = 0; i < graph.length; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < graph[i].length; ++j) {
                set.add(graph[i][j]);
            }
            adj.put(i, set);
        }

        //System.out.println(adj);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(lists, adj, 0, graph.length - 1, list);

        return lists;
    }

    private void dfs(List<List<Integer>> lists, Map<Integer, Set<Integer>> map, int node, int target, List<Integer> list) {
        if (node == target) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i : map.get(node)) {
                list.add(i);
                dfs(lists, map, i, target, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

