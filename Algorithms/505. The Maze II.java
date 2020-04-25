class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        /*
            BFS
            1. similar to Maze 1
            2. instead of using a 2D boolean array to store visited information, use a 2D int array
            3. -1 means not visited, non-negative integer means the distance to this cell
            
            Note: because when we later visited some cell, the distance could be actually shorter, so don't skip when some cell has a positve interger at the 2D visited array. check the current distance, if the current distance is shorter than the positive interger stored, update the integer and don't skip
        */
        if (maze == null || maze.length == 0) return -1;
        
        int row = maze.length, column = maze[0].length, min = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[row][column];
        for (int i = 0; i < row; ++i) {
            Arrays.fill(visited[i], -1);
        }

        queue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = 0;
        
        int[] directionx = {-1,0,1,0};
        int[] directiony = {0,1,0,-1};
        
        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            
            for (int i = 0; i < 4; ++i) {
                int coorx = coors[0] + directionx[i];
                int coory = coors[1] + directiony[i];
                int distance = coors[2] + 1;
                
                while (check(coorx, coory, maze)) {
                    coorx += directionx[i];
                    coory += directiony[i];
                    distance++;
                }
                
                coorx -= directionx[i];
                coory -= directiony[i];
                distance--;
                if (visited[coorx][coory] != -1) {
                    if (distance < visited[coorx][coory]) visited[coorx][coory] = distance;
                    else continue;
                }
                
                if (coorx == destination[0] && coory == destination[1]) {
                    if (distance < min) {
                        min = distance;
                    }
                }
                queue.add(new int[] {coorx, coory, distance});
                visited[coorx][coory] = distance;
                
            }
        }
        
        if (min != Integer.MAX_VALUE) return min;
        return -1;
    }
    
    private boolean check(int x, int y, int[][] maze) {
        int row = maze.length, column = maze[0].length;
        if (x < 0 || y < 0 || x >= row || y >= column || maze[x][y] == 1) return false;
        return true;
    }
}