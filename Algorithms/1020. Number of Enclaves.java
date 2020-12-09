/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] A) {
        /*
            BFS
            add all bounary ones to the queue first
        */
        int ones = 0;
        int row = A.length, col = A[0].length;

        Queue<int[]> queue = new LinkedList<>(); 
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && A[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
                else if (A[i][j] == 1) ones++;
            }
        }

        int[] directionx = {0, 1, 0, -1};
        int[] directiony = {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int newx = cur[0] + directionx[i];
                int newy = cur[1] + directiony[i];

                if (newx < 0 || newx >= row || newy < 0 || newy >= col || A[newx][newy] == 0 || visited[newx][newy]) continue;
                queue.add(new int[] {newx, newy});
                visited[newx][newy] = true;
                ones--;
                if (ones == 0) return 0;
            }
        }

        return ones;
    }
}
// @lc code=end

