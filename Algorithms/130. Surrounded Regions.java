class Solution {
    public void solve(char[][] board) {
        /*
            BFS
        */
        if (board.length == 0) return;
        int row = board.length, column = board[0].length;
        Map<String, Integer> visited = new HashMap<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (board[i][j] == 'O' && !visited.containsKey(i + "," + j)) {
                    bfs(board, i, j, visited);
                }
                visited.put(i + "," + j, 1);
            }
        }
        
    }
    
    private void bfs(char[][] board, int x, int y, Map<String, Integer> visited) {
        visited.put(x + "," + y, 1);
        
        int row = board.length, column = board[0].length;
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        boolean atborder = false;
        
        if (x == 0 || x == row - 1 || y == 0 || y == column - 1) atborder = true;
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            xs.add(pos[0]);
            ys.add(pos[1]);
            
            for (int i = 0; i < 4; ++i) {
                int coorx = pos[0] + directionx[i];
                int coory = pos[1] + directiony[i];
                if (coorx < 0 || coory < 0 || coorx >= row || coory >= column) continue;
                if (board[coorx][coory] == 'O' && !visited.containsKey(coorx + "," + coory)) {
                    if (coorx == 0 || coorx == row - 1 || coory == 0 || coory == column - 1) {
                        atborder = true;
                    }
                    visited.put(coorx + "," + coory, 1);
                    queue.add(new int[] {coorx, coory});
                }
            }
        }
        
        if (!atborder) {
            for (int z = 0; z < xs.size(); ++z) {
                board[xs.get(z)][ys.get(z)] = 'X';
            }
        }
    }
}