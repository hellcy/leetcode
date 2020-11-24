/*
 * @lc app=leetcode id=789 lang=java
 *
 * [789] Escape The Ghosts
 */

// @lc code=start
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        /*
            ghost can go to the target and stay there
            so the question is asking can you be the first one to reach target
        */
        int step = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] arr : ghosts) {
            int dis = Math.abs(target[0] - arr[0]) + Math.abs(target[1] - arr[1]);
            if (dis <= step) return false;
        }
        return true;
    }
}
// @lc code=end

