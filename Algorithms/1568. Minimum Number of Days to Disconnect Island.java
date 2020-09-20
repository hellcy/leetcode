class Solution {
    int[] breakpoint = null;
    int currentones = 0;
    public int minDays(int[][] grid) {
        /*
            bfs
            answer can only be 0, 1 or 2
            if it is not connected at first, return 0
            for every 1 in the grid, if it is not connected after changing 1 to 0, return 1
            return 2 after checking all 1s
        */
        
        int ones = 0;
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, column = grid[0].length;
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 1) {
                    ones++;
                    list.add(new int[] {i, j});
                }
            }
        }
        
        if (ones == 1) return 1;
        
        //boolean[][] visited = new boolean[row][column];
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; ++i) {
            int[] current = list.get(i);
            if (!flag) {
                bfs(grid, current[0], current[1]);
                flag = true;
                if (currentones != ones) return 0;
            }
            
            currentones = 0;
            grid[current[0]][current[1]] = 0;
            int[] nextone = list.get(i + 1);
            bfs(grid, nextone[0], nextone[1]);
            ones--;
            if (currentones != ones) return 1;

            grid[current[0]][current[1]] = 1;
            ones++;
        }
        return 2;
    }
    
    private void bfs(int[][] grid, int x, int y) {
        int[] directionx = {0, 1, 0, -1};
        int[] directiony = {1,0,-1,0};
        
        int row =  grid.length, column = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        
        queue.add(new int[] { x, y});
        visited[x][y] = true;
        currentones++;
        int[] prev = {-1, -1};
        int maxconnection = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int newx = current[0] + directionx[i];
                int newy = current[1] + directiony[i];
                
                if (newx < 0 || newx >= row || newy < 0 || newy >= column || grid[newx][newy] == 0) continue;
                
                if (visited[newx][newy]) {
                    continue;
                }
                queue.add(new int[] {newx, newy});
                visited[newx][newy] = true;
                currentones++;
            }
        }
    }
    
    
}