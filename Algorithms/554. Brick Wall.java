/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int row = wall.size();
        int width = 0;
        for (int i : wall.get(0)) {
            width += i;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int edge = 0;
            for (int i : list) {
                edge += i;
                if (map.containsKey(edge - 1)) {
                    map.put(edge - 1, map.get(edge - 1) + 1);
                } else {
                    map.put(edge - 1, 1);
                }
            }
        }
        //System.out.println(map);
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (key == width - 1) continue;
            min = Math.min(min, row - map.get(key));
        }

        if (min == Integer.MAX_VALUE) return row;
        return min;
    }
}
// @lc code=end

