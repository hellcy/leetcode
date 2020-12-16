/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        /*
            BFS + Union Find
        */
        int row = grid.length, col = grid[0].length;

        int count = 0;
        int[] arr = new int[row * col];
        for (int i = 0; i < arr.length; ++i) 
        {
            arr[i] = i;
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    int index = row * i + j;
                    arr[index] = -1;
                }
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == -1) continue;

            Queue<int[]> queue = new LinkedList<>();
            int x = i % row;
            int y = i / row;
            queue.add(new int[] {x, y});
            int[] directionx = {0, 1, 0, -1};
            int[] directiony = {1, 0, -1, 0};
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int index = cur[0] * row + cur[1];
                for (int j = 0; j < 4; ++i) {
                    int newx = directionx[j] + cur[0];
                    int newy = directiony[j] + cur[1];

                    if (newx < 0 || newx >= row || newy < 0 || newy >= col) {
                        arr[index] = -1;
                        continue;
                    }
                    if (grid[newx][newy] == 1) continue;
                    int root_cur = find(arr, index);
                    int root_new = find(arr, newx * row + newy);
                    if (root_cur != root_new) {
                        arr[root_new] = root_cur;
                    }
                    queue.add(new int[] {newx, newy});
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) 
        {
            if (arr[i] == -1) continue;
            set.add(arr[i]);
        }
        return set.size();
    }

    private int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        return arr[x] = find(arr, arr[x]);
    }
}
// @lc code=end

