/*
 * @lc app=leetcode id=1052 lang=java
 *
 * [1052] Grumpy Bookstore Owner
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0;
        int n = customers.length;
        int cur = 0;
        for (int i = 0; i < X; ++i) {
            if (grumpy[i] == 1) cur += customers[i];
        }

        max = Math.max(max, cur);
        for (int i = X; i < n; ++i) {
            if (grumpy[i] == 1) cur += customers[i];
            if (grumpy[i - X] == 1) cur -= customers[i - X];
            max = Math.max(max, cur);
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (grumpy[i] == 0) ans += customers[i];
        }

        return ans + max;
    }
}
// @lc code=end

