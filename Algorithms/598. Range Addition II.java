/*
 * @lc app=leetcode id=598 lang=java
 *
 * [598] Range Addition II
 */

// @lc code=start
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        if (ops.length == 0) return m * n;
        for (int[] array : ops) {
            minx = Math.min(minx, array[0]);
            miny = Math.min(miny, array[1]);
        }

        return minx * miny;
    }
}
// @lc code=end

