/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int ans = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; ++i) {
            if (pairs[i][0] > end) {
                ans++;
                end = pairs[i][1];
            }
        }
        return ans;
    }
}
// @lc code=end

