class Solution {
    public int[][] transpose(int[][] A) {
        /*
            Algorithm explained: 
                switch row and column
        */
        int r = A[0].length;
        int c = A.length;
        
        int[][] matrix = new int[r][c];
        
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                matrix[i][j] = A[j][i];
            }
        }
        
        return matrix;
    }
}