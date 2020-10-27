/*
 * @lc app=leetcode id=799 lang=java
 *
 * [799] Champagne Tower
 */

// @lc code=start
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        /*
            coordinate dp
        */
        double ans = 0;
        
        double[][] mat = new double[100][100];
        mat[0][0] = poured - 1;
        for (int i = 1; i < 100; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i >= 1 && j >= 1 && mat[i - 1][j - 1] >= 0) mat[i][j] = mat[i - 1][j - 1] / 2.0;
                if (i >= 1 && mat[i - 1][j] >= 0) mat[i][j] += mat[i - 1][j] / 2.0;
                mat[i][j]--;
            }
        }
        if (mat[query_row][query_glass] <= -1) return 0.0;
        else if (mat[query_row][query_glass] >= 0) return 1.0;
        return mat[query_row][query_glass] + 1.0;
    }
}
// @lc code=end

