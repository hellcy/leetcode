/*
 * @lc app=leetcode id=885 lang=java
 *
 * [885] Spiral Matrix III
 */

// @lc code=start
class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int length = 1;
        int points = R * C;
        int index = 0;
        int[][] ans = new int[R * C][2];

        int[] pos = new int[] {r0, c0};
        ans[index] = new int[] {pos[0], pos[1]};

        index++;
        points--;
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        int d = 1;
        while (points > 0) {
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < length; ++j) {
                    pos[0] += directionx[d];
                    pos[1] += directiony[d];
                    if (pos[0] < 0 || pos[0] >= R || pos[1] < 0 || pos[1] >= C) continue;
                    ans[index] = new int[] {pos[0], pos[1]};
                    index++;
                    points--;
                    //System.out.println(index + " " + pos[0] + " " + pos[1]);
                    if (points == 0) return ans;
                }
                d++;
                d = d % 4;
            }
            length++;
        }
        return ans;
    }
}
// @lc code=end

