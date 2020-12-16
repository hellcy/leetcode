/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start
class Solution {
    public int maxDistance(int[][] grid) {
        /*
            BFS
            similar to rotten oranges
            start with all existing lands, change neighbours to land if possible
            find the distance to change the last water to land
        */

        int row = grid.length, col = grid[0].length;
        int water = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                } else {
                    water++;
                }
            }
        }

        // return -1 if all water or all land!
        if (water == 0 || water == row * col) return -1;
        int[] directionx = {1, 0, -1, 0};
        int[] directiony = {0, -1, 0, 1};
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; ++i) {
                    int newx = cur[0] + directionx[i];
                    int newy = cur[1] + directiony[i];
    
                    if (newx < 0 || newx >= row || newy < 0 || newy >= col || grid[newx][newy] == 1) continue;
                    water--;
                    grid[newx][newy] = 1;
                    queue.add(new int[] {newx, newy});
                }
            }
            if (water == 0) return ans;
            ans++;
        }
        return ans;
    }
}
// @lc code=end

