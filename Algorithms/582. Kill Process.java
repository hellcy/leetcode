class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        /*
            Graph
            Create adjacent list for each parent node
        */

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int index = 0;
        for (int i : ppid) {
            if (!map.containsKey(i)) {
                Set<Integer> set = new HashSet<>();
                map.put(i, set);
            }
            map.get(i).add(pid.get(index));
            index++;
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            if (!map.containsKey(cur)) continue;
            for (int neighbour : map.get(cur)) {
                queue.add(neighbour);
            }
        }

        return ans;
    }
}