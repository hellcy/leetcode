/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            We start search the matrix from top right corner, initialize the current position to top right corner, 
            if the target is greater than the value in current position, 
            then the target can not be in entire row of current position because the row is sorted, 
            if the target is less than the value in current position, 
            then the target can not in the entire column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).
        */

        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;

        int x = 0;
        int y = col - 1;
        while (x < row && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else  if (matrix[x][y] < target) {
                x++;
            } else return true;
        }

        return false;
    }
}
// @lc code=end

