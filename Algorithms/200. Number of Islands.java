class Solution {
    /*
        BFS
        1. for each cell in the grid, when its not visited and its value is 1
        2. perform BFS on such cell, find all adjcent 1s, changed them to visited and value to 0
        3. increment the count for each BFS
    */
    int count = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, column = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void bfs(char[][] grid, int x, int y) {
        int[] directionx = {-1, 0, 0, 1};
        int[] directiony = {0, 1, -1, 0};
        int row = grid.length, column = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {x, y});
        
        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            //System.out.println(coors[0] + " " + coors[1]);
            for (int i = 0; i < 4; ++i) {
                int coorx = coors[0] + directionx[i];
                int coory = coors[1] + directiony[i];
                
                if (coorx < 0 || coorx >= row || coory < 0 || coory >= column) continue;
                if (grid[coorx][coory] == '1') {
                    grid[coorx][coory] = 0;
                    queue.add(new int[] {coorx, coory});
                }
            }
        }
        count++;
    }
}