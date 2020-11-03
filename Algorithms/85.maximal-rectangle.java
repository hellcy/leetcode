/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        if (col == 0) return 0;
        boolean[][] dp = new boolean[200 * 1000][200 * 1000];
        int max = 0;
        for (int x1 = 0; x1 < row; ++x1) {
            for (int y1 = 0; y1 < col; ++y1) {
                for (int x2 = x1; x2 < row; ++x2) {
                    for (int y2 = y1; y2 < col; ++y2) {
                        int first = x1 * 1000 + y1;
                        int second = x2 * 1000 + y2;
                        int thrid = x2 * 1000 + (y2 - 1);
                        int fourth = (x2 - 1) * 1000 + y2;
                        if (x1 == x2 && y1 == y2 && matrix[x1][y1] == '1') {
                            dp[first][second] = true;
                            //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
                            max = Math.max(max, 1);
                            continue;
                        }
                        dp[first][second] = false;
                        if (y2 - 1 >= y1) {
                            dp[first][second] |= dp[first][thrid] && checkcol(x1, x2, y2, matrix);
                        }
                        if (x2 - 1 >= x1) {
                            dp[first][second] |= dp[first][fourth] && checkrow(y1, y2, x2, matrix);
                        }
                        //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

                        if (dp[first][second]) {
                            max = Math.max(max, (y2 - y1 + 1) * (x2 - x1 + 1));
                            //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
                        }
                    }
                }
            }
        }

        return max;
    }

    private boolean checkrow(int start, int end, int row, char[][] matrix) {
        for (int i = start; i <= end; ++i) {
            if (matrix[row][i] != '1') return false;
        }

        return true;
    }

    private boolean checkcol(int start, int end, int col, char[][] matrix) {
        for (int i = start; i <= end; ++i) {
            if (matrix[i][col] != '1') return false;
        }

        return true;
    }

    private int encode(int x, int y) {
        return x * 1000 + y;
    }
}
// @lc code=end

