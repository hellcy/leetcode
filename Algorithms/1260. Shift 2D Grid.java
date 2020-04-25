class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int z) {
        /*
            List
            2D Array
        */
        List<List<Integer>> matrix = new ArrayList<>();
        int row = grid.length;
        int column = grid[0].length;
        
        for (int i = 0; i < z; ++i) {
            int[][] copy = new int[row][column];
            for (int j = 0; j < row; ++j) {
                for (int k = 0; k < column - 1; ++k) {
                    copy[j][k + 1] = grid[j][k];
                }
            }
            
            for (int j = 0; j < row - 1; ++j) {
                copy[j + 1][0] = grid[j][column - 1];
            }
            
            copy[0][0] = grid[row - 1][column - 1];
            
            grid = copy;
            // for (int[] rows: copy)
            //     Arrays.fill(rows, 0);
        }
        
        for (int i = 0; i < row; ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < column; ++j) {
                temp.add(grid[i][j]);
            }
            matrix.add(temp);
        }
        
        return matrix;
    }
}