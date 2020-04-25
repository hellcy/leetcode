class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        /*
            two demensional array
        */
        int[][] matrix = new int[n][m];
        
        for (int i = 0; i < indices.length; ++i) {
            int row = indices[i][0];
            int column = indices[i][1];
            
            for (int j = 0; j < m; ++j) {
                matrix[row][j]++;
            }
            
            for (int j = 0; j < n; ++j) {
                matrix[j][column]++;
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[j][i] % 2 != 0) count++;
            }
        }
        
        return count;
    }
}