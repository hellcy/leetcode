class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        /*
            Algorithm explained:
                brute force
                first create a new matrix, reversely add new values from A to result matrix
                then invert result matrix by change value from 0 to 1 and 1 to 0
        */
        int r = A.length - 1;
        int c = A[0].length - 1;
        int[][] result = new int[A.length][A[0].length];
        
        // reverse and invert each row
        for (int i = 0; i <= r; ++i) {
            for (int j = 0; j <= c; ++j) {
                if (A[i][j] == 0) result[i][c - j] = 1;
                else result[i][c - j] = 0;
            }
        }
        
        return result;
    }
}