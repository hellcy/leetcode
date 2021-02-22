class Solution {
    public int[][] highestPeak(int[][] isWater) {
        /*
            BFS
            Find the farest land we can get from any water cell
        */

        int row = isWater.length, col = isWater[0].length;
        int[][] ans = new int[row][col];

        Queue<Integer> queue = new LinkedList<>();
        int total = row * col;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (isWater[i][j] == 1) {
                    total--;
                    queue.add(i * col + j);
                    visited.add(i * col + j);
                    ans[i][j] = 0;
                }
            }
        }

        if (total == 0) return ans;

        int step = 0;
        int[] directionx = {1, 0, -1, 0};
        int[] directiony = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int num = queue.poll();
                int x = num / col;
                int y = num % col;
                for (int j = 0; j < 4; ++j) {
                    int newx = x + directionx[j];
                    int newy = y + directiony[j];

                    if (newx < 0 || newx >= row || newy < 0 || newy >= col || visited.contains(newx * col + newy)) continue;
                    queue.add(newx * col + newy);
                    visited.add(newx * col + newy);
                    ans[newx][newy] = step + 1;
                    total--;
                    if (total == 0) return ans;
                }
            }
            step++;
        }

        return ans;
    }
}