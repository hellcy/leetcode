class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        /*
            BFS on a 2D-array
            start at the starting cell, go to the next four possible cells step by step until all possible cells are visited or the destrination has been reached
        */
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        if (maze == null || maze.length == 0) return false;
        int row = maze.length, column = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        boolean[][] visited = new boolean[row][column];
        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            visited[coors[0]][coors[1]] = true;
            
            for (int i = 0; i < 4; ++i) {
                int coorx = coors[0] + directionx[i];
                int coory = coors[1] + directiony[i];
                
                while (inborder(coorx, coory, maze) && maze[coorx][coory] == 0) {
                    coorx += directionx[i];
                    coory += directiony[i];
                }
                
                coorx -= directionx[i];
                coory -= directiony[i];
                
                if (coorx == destination[0] && coory == destination[1]) return true;
                else if (maze[coorx][coory] == 0 && !visited[coorx][coory]) {
                    queue.add(new int[] {coorx, coory});
                    visited[coorx][coory] = true;
                }
            }
        }
        
        return false;
    }
    
    private boolean inborder(int x, int y, int[][] maze) {
        int row = maze.length, column = maze[0].length;
        if (x < 0 || y < 0 || x >= row || y >= column) return false;
        return true;
    }
}