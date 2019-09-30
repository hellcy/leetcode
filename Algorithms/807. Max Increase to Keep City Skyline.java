class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        /*
            Brute force
        */
        int r = grid.length;
        int c = grid[0].length;
        
        int sum = 0;
        int[] maxrow = new int[r];
        int[] maxcolumn = new int[c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                sum += grid[i][j];
                maxrow[i] = Math.max(maxrow[i], grid[i][j]);
            }
        }
        
        for (int j = 0; j < c; ++j) {
            for (int i = 0; i < r; ++i) {
                maxcolumn[j] = Math.max(maxcolumn[j], grid[i][j]);
            }
        }
        
        int afterSum = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                grid[i][j] = Math.min(maxrow[i], maxcolumn[j]);
                afterSum += grid[i][j];
            }
        }
        return afterSum - sum;
    }
}