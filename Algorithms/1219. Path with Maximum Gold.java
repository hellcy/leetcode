class Solution {
    int sum = 0;
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        /*
            Backtracking
                remember to change the visited value back to zero when we finish a route
        */
        int[][] visited = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 0) {
                    helper(grid, i, j, sum, visited);
                }
            }
        } 
        return max;
    }
    
    private void helper(int[][] grid, int x, int y, int sum, int[][] visited) {
        //System.out.println(x + " " + y + " " + sum);
        if (grid[x][y] == 0 || visited[x][y] == 1) {
            max = Math.max(sum, max);
            return;
        }
        int localx = x, localy = y;
        sum += grid[x][y];
        visited[x][y] = 1;
        //System.out.println(x + " " + y + " " + sum);
        localx++;
        if (localx < grid.length) helper(grid, localx, y, sum, visited);
        
        localx = x;
        localy++;
        if (localy < grid[0].length) helper(grid, x, localy, sum, visited);
        
        localy = y;
        localx--;
        if (localx >= 0) helper(grid, localx, y, sum, visited);
        
        localx = x;
        localy--;
        if (localy >= 0) helper(grid, x, localy, sum, visited);
        
        // when we finish a route, change values back
        visited[x][y] = 0;
    }
}