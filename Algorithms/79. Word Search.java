class Solution {
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        /*
            DFS
        */
        if (board == null || board.length == 0) return false;
        
        int row = board.length, column = board[0].length;
        
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                dfs(i, j, board, "", word, visited);
                if (ans) return true;
            }
        }
        
        return ans;
    }
    
    private void dfs(int x, int y, char[][] board, String s, String word, boolean[][] visited) {
        if (!ans) {
            if (s.length() < word.length() && board[x][y] == word.charAt(s.length())) {
                s = s + String.valueOf(board[x][y]);
                if (s.equals(word)) {
                    ans = true;
                    return;
                }
                int[] directionx = {-1, 0, 1, 0};
                int[] directiony = {0, 1, 0, -1};
                int row = board.length, column = board[0].length;
                for (int i = 0; i < 4; ++i) {
                    int coorx = x + directionx[i];
                    int coory = y + directiony[i];
                    
                    if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || visited[coorx][coory]) continue;
                    visited[x][y] = true;
                    dfs(coorx, coory, board, s, word, visited);
                    visited[x][y] = false;
                }
            }
        }
    }
}