/*
 * @lc app=leetcode id=390 lang=java
 *
 * [390] Elimination Game
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        /*
            first set last number to 1
            there is a 2 situations that we need to update last number
            1. when we delete from left
            2. when we delete from right and numbers left is odd

            interval is the diff between two adjcent numbers
        */
        int lastnum = 1;
        boolean fromleft = true;
        int interval = 1;
        int count = n;
        while (count > 1) {
            if (fromleft) {
                lastnum += interval;
            } else if (!fromleft && count % 2 == 1) {
                lastnum += interval;
            }
            fromleft = !fromleft;
            interval *= 2;
            count /= 2;
        }

        return lastnum;
    }
}
// @lc code=end

