class Solution {
    /*
        because matrix is mono increasing so
        check first number of each row
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        if (column == 0) return false;
        int count = 0;
        while (count < row && target >= matrix[count][0]) {
            count++;
        }
        count--;
        if (count < 0) return false;
        for (int i = 0; i < column; ++i) {
            if (target == matrix[count][i]) return true;
        }
        
        return false;
    }
}