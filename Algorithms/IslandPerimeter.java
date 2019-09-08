class Solution {
    public int islandPerimeter(int[][] grid) {
        /*
            the max perimeter of a land cell should be 4, but if connect to other land cell, the total perimeter will decrease
            calculate the number of 1's that are connect to other 1's
        */
        int connect = 0;
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 1) {
                    count++;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) connect++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) connect++;
                    if (j + 1 < column && grid[i][j + 1] == 1) connect++;
                    if (i + 1 < row && grid[i + 1][j] == 1) connect++;
                }
            }
        }
        
        return count * 4 - connect;
        
    }
    
}