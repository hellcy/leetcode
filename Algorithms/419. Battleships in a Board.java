class Solution {
    public int countBattleships(char[][] board) {
        /*
            Brute force
                whenever we see a 'X', check cells on its left and top, if they are both '.', then count++
                special case when 'X' at [0][0]
        */
        int row = board.length;
        int column = board[0].length;
        
        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (board[i][j] == 'X' && (j == 0 || board[i][j - 1] != 'X') && (i == 0 || board[i - 1][j] != 'X')) {
                    count++;
                }
            }
        }
        
        return count;
    }
}