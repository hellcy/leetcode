class Solution {
    public int surfaceArea(int[][] grid) {
        /*
            Matrix
        */
        int total = 0, row = grid.length, column = grid[0].length;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (i - 1 >= 0) total += Math.max(grid[i][j] - grid[i - 1][j], 0);
                else total += grid[i][j];
                
                if (j - 1 >= 0) total += Math.max(grid[i][j] - grid[i][j - 1], 0);
                else total += grid[i][j];

                if (i + 1 < row) total += Math.max(grid[i][j] - grid[i + 1][j], 0);
                else total += grid[i][j];

                if (j + 1 < column) total += Math.max(grid[i][j] - grid[i][j + 1], 0);
                else total += grid[i][j];
                
                if (grid[i][j] != 0) total += 2;
            }
        }
        

        return total;
    }
}