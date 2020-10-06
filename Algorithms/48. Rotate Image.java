class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row % 2 == 0) {
            for (int i = 0; i < row / 2; ++i) {
                for (int j = 0; j < col / 2; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[row - j - 1][i];
                    matrix[row - j - 1][i] = matrix[row - i - 1][row - j - 1];
                    matrix[row - i - 1][row - j - 1] = matrix[j][row - i - 1];
                    matrix[j][row - i - 1] = temp;
                }
            }
        } else {
           for (int i = 0; i < row / 2 + 1; ++i) {
                for (int j = 0; j < col / 2; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[row - j - 1][i];
                    matrix[row - j - 1][i] = matrix[row - i - 1][row - j - 1];
                    matrix[row - i - 1][row - j - 1] = matrix[j][row - i - 1];
                    matrix[j][row - i - 1] = temp;
                }
            }
        }
    }
}