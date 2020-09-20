class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        
        int row = board.length, col = board[0].length;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] != '.') {
                    if (!check(j, i, board, board[i][j])) {
                        //System.out.println(i + " " + j);
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean check(int x, int y, char[][] board, char num) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; ++i) {
            if (i != y && board[i][x] == num) return false;
        }
        
        for (int i = 0; i < col; ++i) {
            if (i != x && board[y][i] == num) return false;
        }
        
        int startx = 0, starty = 0;
        if (x >= 0 && x < 3) startx = 0;
        else if (x >= 3 && x < 6) startx = 3;
        else startx = 6;
        
        if (y >= 0 && y < 3) starty = 0;
        else if (y >= 3 && y < 6) starty = 3;
        else starty = 6;
        //System.out.println(startx + " " + starty);
        for (int i = starty; i < starty + 3; ++i) {
            for (int j = startx; j < startx + 3; ++j) {
                if (i != y && j != x && board[i][j] == num) return false;
            }
        }
        
        return true;
    }
}