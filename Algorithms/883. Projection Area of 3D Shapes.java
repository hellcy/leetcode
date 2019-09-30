class Solution {
    public int projectionArea(int[][] grid) {
        /*
            from the top, count all non-zero grid
            from the front, count the max grid on each column
            from the side, count the max grid on each row
            then all them all together
        */
        
        int maxcolumn = 0;
        int maxrow = 0;
        int count = 0;
        
        int row = grid.length;
        int column = grid[0].length;
        
        for (int i = 0; i < row; ++i) {
            maxrow = 0;
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] != 0) count++;
                maxrow = Math.max(maxrow, grid[i][j]);
            }
            count += maxrow;
            //System.out.println(maxrow);
        }
        
        for (int i = 0; i < column; ++i) {
            maxcolumn = 0;
            for (int j = 0; j < row; ++j) {
                maxcolumn = Math.max(maxcolumn, grid[j][i]);
            }
            count += maxcolumn;
            //System.out.println(maxcolumn);
        }
        
        return count;
    }
}