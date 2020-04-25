class Solution {
    public int orangesRotting(int[][] grid) {
        /*
            BFS
            1. add all zeros into a queue and mark them as visited
            2. start at these zeros, level by level, until fresh oranges reduced to zero or queue is empty
            3. increment level when we finish the whole level
        */
        int fresh = 0;
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, column = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) fresh++;
            }
        }
        
        if (fresh == 0) return 0;
        
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int[] coors = queue.poll();
                for (int i = 0; i < 4; ++i) {
                    int coorx = coors[0] + directionx[i];
                    int coory = coors[1] + directiony[i];

                    if (coorx >=0 && coorx < row && coory >= 0 && coory < column) {
                        if (grid[coorx][coory] == 1) {
                            grid[coorx][coory] = 2;
                            fresh--;
                            visited[coorx][coory] = true;
                            if (fresh == 0) return level;
                            queue.add(new int[] {coorx, coory});
                        }
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}