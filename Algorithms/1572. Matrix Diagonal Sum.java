class Solution {
    public int diagonalSum(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        
        int row = mat.length, column = mat[0].length;
        
        int ans = 0;
        
        int i = 0, j = 0;
        while (i < row && j < column) {
            ans += mat[i][j];
            i++;
            j++;
        }
        
        i = 0;
        j = column - 1;
        while (i < row && j >= 0) {
            ans += mat[i][j];
            i++;
            j--;
        }
        
        if (column % 2 != 0) {
            ans -= mat[column / 2][column / 2];
        }
        
        return ans;
    }
}