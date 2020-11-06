/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        /*
            in-place
            live now but will die -1
            dead now but will live -2
        */

        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        if (col == 0) return;

        int[] directionx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] directiony = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int count = 0;
                int now = board[i][j];
                for (int k = 0; k < 8; ++k) {
                    int x = i + directionx[k];
                    int y = j + directiony[k];
                    if (x < 0 || x >= row || y < 0 || y >= col) continue;
                    if (board[x][y] == 1 || board[x][y] == -1) {
                        count++;
                    }
                }
                if (count < 2 && now == 1) board[i][j] = -1;
                else if ((count == 2 || count == 3) && now == 1) board[i][j] = 1;
                else if (count > 3 && now  == 1) board[i][j] = -1;
                else if (count == 3 && now == 0) board[i][j] = -2;
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == -2) board[i][j] = 1;
            }
        }
    }
}
// @lc code=end

