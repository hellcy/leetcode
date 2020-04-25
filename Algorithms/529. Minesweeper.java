class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        /*
            BFS
            1. start at click
            2. if it has adjcent mines, update the value, stop here
            3. if it hasn't, change value to 'B', put adjcent cells into the queue
        */
        int row = board.length, column = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        queue.add(click);
        
        int[] directionx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] directiony = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            //System.out.println(coors[0] + " " + coors[1]);
            int mine = hasmine(coors[0], coors[1], board);
            if (mine > 0) {
                board[coors[0]][coors[1]] = (char)(mine + '0');
            } else {
                board[coors[0]][coors[1]] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int coorx = coors[0] + directionx[i];
                    int coory = coors[1] + directiony[i];

                    if (!check(coorx, coory, board) || visited[coorx][coory]) {
                        continue;
                    }

                    if (board[coorx][coory] == 'E' && !visited[coorx][coory]) {
                        queue.add(new int[] {coorx, coory});
                        visited[coorx][coory] = true;
                    }
                }
            }
        }
        return board;
    }
    
    private boolean check(int x, int y, char[][] board) {
        int row = board.length, column = board[0].length;
        
        if (x < 0 || x >= row || y < 0 || y >= column) return false;
        return true;
    }
    
    private int hasmine(int x, int y, char[][] board) {
        int row = board.length, column = board[0].length;
        int mine = 0;
        //System.out.println(x + " " + y);
        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 'M') mine++;
        if (x - 1 >= 0 && board[x - 1][y] == 'M') mine++;
        if (x - 1 >= 0 && y + 1 < column && board[x - 1][y + 1] == 'M') mine++;
        
        if (y - 1 >= 0 && board[x][y - 1] == 'M') mine++;
        if (y + 1 < column && board[x][y + 1] == 'M') mine++;
        
        if (x + 1 < row) {
            if (y - 1 >= 0 && board[x + 1][y - 1] == 'M') mine++;
            if (board[x + 1][y] == 'M') mine++;
            if (y + 1 < column && board[x + 1][y + 1] == 'M') mine++;
        }
        
        return mine;
    }
}