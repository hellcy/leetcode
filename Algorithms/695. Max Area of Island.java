class Solution {
    /*
        BFS
    */
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                }
            }
        }
        return max;
    }
    
    private void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        
        int row = grid.length, column = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            
            for (int i = 0; i < 4; ++i) {
                int coorx = coors[0] + directionx[i];
                int coory = coors[1] + directiony[i];
                
                if (coorx < 0 || coorx >= row || coory < 0 || coory >= column) continue;
                if (grid[coorx][coory] == 1 && !visited[coorx][coory]) {
                    queue.add(new int[] {coorx, coory});
                    visited[coorx][coory] = true;
                    count++;
                }
            }
        }
        
        if (count > max) max = count;
    }
}