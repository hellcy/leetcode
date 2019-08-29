class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        /*
            Algorithm explained:
                start from top-left corner
                check every cell to see if its value equals to the cell to its top-left
        */
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}