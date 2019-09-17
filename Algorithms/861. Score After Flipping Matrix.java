class Solution {
    public int matrixScore(int[][] A) {
        /*
            Notice that a 1 in the iith column from the right, contributes 2^i2 i to the score. 
            Since maximizing the left-most digit is more important than any other digit. 
            Thus, the rows should be toggled such that the left-most column is either all 0 or all 1, 
            so that after toggling the left-most column [if necessary], the left column is all 1.
            
            A[r][c] ^= A[r][0] This means toggle the necessary rows to make the first column all 0
            after that simply figure out if you gain or not from flipping subsequent columns.
            
            Afterwards, the base score is max(col, R - col) where col is the column sum; 
            and (1 << (C-1-c)) is the power of 2 that each 1 in that column contributes to the score.
        */
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {
            int col = 0;
            for (int r = 0; r < R; ++r) {
                col += A[r][c] ^ A[r][0];
                System.out.print((A[r][c] ^ A[r][0]) + " ");
            }
            ans += Math.max(col, R - col) * (1 << (C-1-c));
        }
        return ans;
    }
}