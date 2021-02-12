/*
 * @lc app=leetcode id=1267 lang=java
 *
 * [1267] Count Servers that Communicate
 */

// @lc code=start
class Solution {
    public int countServers(int[][] grid) {
        /*
            BFS
            for each server, check the row and col, add all servers to ans and mark them as visited
            -1: no server
            0: server
            1: visited server
        */

        int row = grid.length, col = grid[0].length;
        int[] visited = new int[row * col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    int index = i * col + j;
                    visited[index] = -1;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i] == -1 || visited[i] == 1) continue;

            boolean found = false;
            int curx = i / col;
            int cury = i % col;
            int pos = -1;
            // up
            pos = curx - 1;
            while (pos >= 0) {
                int index = pos * col + cury;
                if (grid[pos][cury] == 1) {
                    found = true;
                    if (visited[index] == 0) ans++;
                    visited[index] = 1;
                }
                pos--;
            }

            // down
            pos = curx + 1;
            while (pos < row) {
                int index = pos * col + cury;
                if (grid[pos][cury] == 1) {
                    found = true;
                    if (visited[index] == 0) ans++;
                    visited[index] = 1;
                }
                pos++;
            }

            // left
            pos = cury + 1;
            while (pos < col) {
                int index = curx * col + pos;
                if (grid[curx][pos] == 1) {
                    found = true;
                    if (visited[index] == 0) ans++;
                    visited[index] = 1;
                }
                pos++;
            }

            // right
            pos = cury - 1;
            while (pos >= 0) {
                int index = curx * col + pos;
                if (grid[curx][pos] == 1) {
                    found = true;
                    if (visited[index] == 0) ans++;
                    visited[index] = 1;
                }
                pos--;
            }

            if (found) {
                ans++;
                visited[curx * col + cury] = 1;
            }
        }

        return ans;
    }
}
// @lc code=end

