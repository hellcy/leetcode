/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    /*
        presum each point
    */
    int[][] presum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        presum = new int[matrix.length][matrix[0].length];
        
        int row = presum.length;
        int col = presum[0].length;
        if (row == 0 || col == 0) return;
        presum[0][0] = matrix[0][0];
        for (int i = 1; i < col; ++i) {
            presum[0][i] = presum[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < row; ++i) {
            presum[i][0] = presum[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = presum[row2][col2];

        if (row1 > 0) ans -= presum[row1 - 1][col2];
        if (col1 > 0) ans -= presum[row2][col1 - 1];
        if (row1 > 0 && col1 > 0) ans += presum[row1 - 1][col1 - 1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

