class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] < 0) {
                    count += column - j;
                    break;
                }
            }
        }
        
        return count;
    }
}