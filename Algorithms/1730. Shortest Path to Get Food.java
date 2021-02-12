class Solution {
    public int getFood(char[][] grid) {
        /*
            BFS
            * -> person
            # -> food
            O -> free space
            X -> obstacle
        */

        int row = grid.length;
        if (row == 0) return -1;
        int col = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '*') {
                    queue.add(i * col + j);
                    visited.add(i * col + j);
                    break;
                }
            }
        }

        int[] directionx = {0, 1, 0, -1};
        int[] directiony = {1, 0, -1, 0};
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                int x = cur / col;
                int y = cur % col;
                for (int j = 0; j < 4; ++j) {
                    int newx = directionx[j] + x;
                    int newy = directiony[j] + y;
                    
                    if (newx < 0 || newx >= row || newy < 0 || newy >= col || grid[newx][newy] == 'X' || visited.contains(newx * col + newy)) continue;
                    if (grid[newx][newy] == '#') return ans + 1;
                    queue.add(newx * col + newy);
                    visited.add(newx * col + newy);
                }
            }
            ans++;
        }

        return -1;
    }
}