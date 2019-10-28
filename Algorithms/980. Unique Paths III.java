class Solution {
    /*
        Backtracking
            create another grid to keep track of visited positions
    */
    int path = 0;
    public int uniquePathsIII(int[][] grid) {
        int step = 2;
        int x = 0, y = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    step++;
                } else if (grid[i][j] == 1) {
                    // get the starting position
                    x = i;
                    y = j;
                }
            }
        }
        //System.out.println(grid.length + " " + grid[0].length + " " + grid[2][3]);
        int[][] visited = new int[grid.length][grid[0].length];
        
        helper(grid, visited, x, y, 1, step);
        return path;
    }
    
    private void helper(int[][] grid, int[][] visited, int x, int y, int count, int step) {
        //System.out.println(x + " " + y + " " + count);
        if (grid[x][y] == 2) {
            if (step == count) {
                path++;
            }
            return;
        } else if (grid[x][y] == -1) return;
        
        visited[x][y] = 1;
        
        if (y - 1 >= 0 && grid[x][y - 1] != -1 && grid[x][y - 1] != 1 && visited[x][y - 1] != 1) helper(grid, visited, x, y - 1, count + 1, step);
        if (x - 1 >= 0 && grid[x - 1][y] != -1 && grid[x - 1][y] != 1 && visited[x - 1][y] != 1) helper(grid, visited, x - 1, y, count + 1, step);
        if (y + 1 < grid[0].length && grid[x][y + 1] != -1 && grid[x][y + 1] != 1 && visited[x][y + 1] != 1) helper(grid, visited, x, y + 1, count + 1, step);
        if (x + 1 < grid.length && grid[x + 1][y] != -1 && grid[x + 1][y] != 1 && visited[x + 1][y] != 1) helper(grid, visited, x + 1, y, count + 1, step);
        
        // when we finish a route, change the visited value back
        visited[x][y] = 0;
    }
}