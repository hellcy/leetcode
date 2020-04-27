class Solution {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        /*
            BFS
            for each 1 cell at (x, y), search for (x, y + 1), (x + 1, y + 1), (x + 1, y)
            square area plus one if all cells at the current level are valid '1'.
        */
        
        if (matrix == null || matrix.length == 0) return 0;
        
        int row = matrix.length, column = matrix[0].length;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (matrix[i][j] == '1') {
                    bfs(matrix, i, j);
                }
            }
        }
        
        return max * max;
    }
    
    private void bfs(char[][] matrix, int x, int y) {
        int row = matrix.length, column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        int tempmax = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        
        max = Math.max(max, tempmax);
        int[] directionx = {0, 1, 1};
        int[] direcitony = {1, 1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                int[] coors = queue.poll();
                
                for (int j = 0; j < 3; ++j) {
                    int coorx = coors[0] + directionx[j];
                    int coory = coors[1] + direcitony[j];
                    //System.out.println(coorx + " " + coory + " " + tempmax + " " + max);
                    if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || matrix[coorx][coory] == '0') {
                        max = Math.max(max, tempmax);
                        //System.out.println(max);
                        return;
                    }
                    
                    if (visited[coorx][coory]) continue;
                    queue.add(new int[] {coorx, coory});
                    visited[coorx][coory] = true;
                }
            }
            tempmax++;
        }
        max = Math.max(max, tempmax);
    }
}
