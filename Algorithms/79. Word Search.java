class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        /*
            DFS
        */

        if (board == null || board.length == 0) return false;
        int row = board.length, col = board[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                char c = word.charAt(0);
                if (board[i][j] == c) {
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    dfs(board, word, 0, i, j, visited);
                }
            }
        }

        return flag;
    }

    private void dfs(char[][] board, String word, int step, int x, int y, boolean[][] visited) {
        if (step == word.length() - 1) {
            flag = true;
            return;
        }
        else if (!flag && step < word.length() - 1) {
            int[] directionx = {0,1,0,-1};
            int[] directiony = {1,0,-1,0};

            for (int i = 0; i < 4; ++i) {
                int newx = x + directionx[i];
                int newy = y + directiony[i];
                if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) continue;
                char c = board[newx][newy];
                if (!visited[newx][newy] && c == word.charAt(step + 1)) {
                    visited[newx][newy] = true;
                    //System.out.println(c + " " + step);
                    dfs(board, word, step + 1, newx, newy, visited);
                    visited[newx][newy] = false;
                }
            }
        }
    }
}