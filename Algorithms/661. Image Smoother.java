class Solution {
    public int[][] imageSmoother(int[][] M) {
        /*
            Algorithm explained:
                For each cell in the grid, look at the immediate neighbors - up to 9 of them, including the original cell.
                Then, we will add the sum of the neighbors into ans[r][c] while recording count, 
                the number of such neighbors. The final answer is the sum divided by the count.
        */
        int row = M.length;
        int column = M[0].length;
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                matrix[i][j] = check(M, i, j, row, column);
            }
        }
        
        return matrix;
    }
    
    private int check(int[][] M, int x, int y, int row, int column) {
        int target = 0;
        int count = 0;
        for (int i = x - 1; i < x + 2; ++i) {
            for (int j = y - 1; j < y + 2; ++j) {
                if (i >= 0 && j >= 0 && i < row && j < column) {
                    target += M[i][j];
                    count++;
                }
            }
        }
        return target / count;
    }
    
}