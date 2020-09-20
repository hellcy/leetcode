class Solution {
    public int maxKilledEnemies(char[][] grid) {
        /*
            dp
            for each cell, we need to calculate all four directions
            e.g. for up direction, the number of enemies killed at cell [i][j] = [i - 1][j] or [i - 1][j] + 1 if cell [i][j] is 'E'
            same goes for the other directions
            then for each empty cell, calculate the sum of 4 directions and pick the max value
        */
        
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length, column = grid[0].length;
        
        int[][] up = new int[row][column];
        int[][] down = new int[row][column];
        int[][] left = new int[row][column];
        int[][] right = new int[row][column];
        
        // up
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    continue;
                }
                
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i > 0) up[i][j] += up[i - 1][j];
            }
        }
        
        // down
        for (int i = row - 1; i >= 0; --i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    continue;
                }
                
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i < row - 1) down[i][j] += down[i + 1][j];
            }
        }
        
        // left
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                    continue;
                }
                
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j > 0) left[i][j] += left[i][j - 1];
            }
        }
        
        // right
        for (int i = 0; i < row; ++i) {
            for (int j = column - 1; j >= 0; --j) {
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                    continue;
                }
                
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j < column - 1) right[i][j] += right[i][j + 1];
            }
        }
        
        int max = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == '0') {
                    int sum = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    max = Math.max(max, sum);
                }
            }
        }
        
        return max;
    }
}