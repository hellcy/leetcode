class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        /*
            compare ith row and ith col, find the smaller one
        */
        
        int row = rowSum.length, col = colSum.length;
        int[][] matrix = new int[row][col];
        
        int currentRow = 0, currentCol = 0;
        while (currentRow < row && currentCol < col) {
            if (rowSum[currentRow] <= colSum[currentCol]) {
                colSum[currentCol] -= rowSum[currentRow];
                matrix[currentRow][currentCol] = rowSum[currentRow];
                for (int i = currentCol + 1; i < col; ++i) {
                    matrix[currentRow][i] = 0;
                }
                currentRow++;
            } else {
                rowSum[currentRow] -= colSum[currentCol];
                matrix[currentRow][currentCol] = colSum[currentCol];
                for (int i = currentRow + 1; i < row; ++i) {
                    matrix[i][currentCol] = 0;
                }
                currentCol++;
            }
        }
        
        return matrix;
    }
}