class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        Boolean firstCol = false;
        
        // Since first cell for both first row and first column is the same i.e. matrix[0][0]
        // We can use an additional variable for either the first row/column.
        // For this solution we are using an additional variable for the first column
        // and using matrix[0][0] for the first row.
        for (int i = 0; i < row; ++i) {
            if (matrix[i][0] == 0) firstCol = true;
            
            for (int j = 1; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
       // for (int i = 0; i < row; ++i) {
       //      for (int j = 0; j < col; ++j) {
       //          System.out.print(matrix[i][j] + " ");
       //      }
       //     System.out.println();
       //  }
        
        for (int i = 1; i < row; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < col; ++i) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < row; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int i = 0; i < col; ++i) {
                matrix[0][i] = 0;
            }
        }
        
        // See if the first column needs to be set to zero as well
        if (firstCol) {
            for (int i = 0; i < row; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}