/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
                max = Integer.MIN_VALUE;
            }
        }

        return ans;
    }
}
// @lc code=end

