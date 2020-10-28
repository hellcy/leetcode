class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int x = -1, y = -1;
        
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        int currow = x;
        while (currow >= 0) {
            if (board[currow][y] == 'B') {
                break;
            } else if (board[currow][y] == 'p') {
                count++;
                break;
            }
            currow--;
        }
        
        currow = x;
        while (currow < row) {
            if (board[currow][y] == 'B') {
                break;
            } else if (board[currow][y] == 'p') {
                count++;
                break;
            }
            currow++;
        }
        
        int curcol = y;
        while (curcol >= 0) {
            if (board[x][curcol] == 'B') {
                break;
            } else if (board[x][curcol] == 'p') {
                count++;
                break;
            }
            curcol--;
        }
        
        curcol = y;
        while (curcol < col) {
            if (board[x][curcol] == 'B') {
                break;
            } else if (board[x][curcol] == 'p') {
                count++;
                break;
            }
            curcol++;
        }
        
        return count;
    }
}