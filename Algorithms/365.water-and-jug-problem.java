/*
 * @lc app=leetcode id=365 lang=java
 *
 * [365] Water and Jug Problem
 */

// @lc code=start
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        Set<Integer> cdx = new HashSet<>();
        for (int i = 2; i * i < x; ++i) {
            if (x % i == 0) {
                cdx.add(i);
            }
        }

        for (int i = 2; i * i < y; ++i) {
            if (y % i == 0) {
                if (cdx.contains(i)) return true;
            }
        }

        return false;
    }
}
// @lc code=end

