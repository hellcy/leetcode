class Solution {
    int min = Integer.MAX_VALUE;
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> ban = new HashSet<>();
        for (int i : forbidden) {
            ban.add(i);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.pop();
                if (cur[0] < 0) continue;
                if (visited.contains(cur[0])) continue;
                if (cur[0] > x + b) continue;
                if (ban.contains(cur[0])) continue;
                visited.add(cur[0]);
                if (cur[1] == 0) {
                    queue.add(new int[] {cur[0] - b, 1});
                }
                queue.add(new int[] {cur[0] + a, 0});
            }
        }
        return min;
    }

    // private void helper(Set<Integer> ban, int a, int b, int x, int count, int index, Set<Integer> visited) {
    //     if (visited.contains(index)) return;
    //     if (index > x + b) return;
    //     if (ban.contains(index)) return;
    //     if ()
    //     helper(ban, a, b, x, )
    // }
}