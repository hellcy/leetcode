class Solution {
    int mod = (int)10e8 + 7;
    long max = -1;
    public int maxProductPath(int[][] grid) {        
        /*
            coor dp
            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k])
            dp[i][j][k] = Math.min(dp[i - 1][j][k], dp[i][j - 1][k])
        */
        
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length, col = grid[0].length;
        long[][][] dp = new long[row][col][2];
        
        for (int i = 0; i < row; ++i) {
            if (i == 0) {
                dp[i][0][0] = grid[i][0];
                dp[i][0][1] = grid[i][0];
            } else {
                dp[i][0][0] = grid[i][0] * dp[i - 1][0][0];
                dp[i][0][1] = grid[i][0] * dp[i - 1][0][1];
            }
        }
        
        for (int i = 0; i < col; ++i) {
            if (i == 0) {
                dp[0][i][0] = grid[0][i];
                dp[0][i][1] = grid[0][i];
            } else {
                dp[0][i][0] = grid[0][i] * dp[0][i - 1][0];
                dp[0][i][1] = grid[0][i] * dp[0][i - 1][1];
            }
        }
        
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                long tempmax = dp[i - 1][j][0] * grid[i][j];
                tempmax = Math.max(tempmax, dp[i - 1][j][1] * grid[i][j]);
                tempmax = Math.max(tempmax, dp[i][j - 1][0] * grid[i][j]);
                tempmax = Math.max(tempmax, dp[i][j - 1][1] * grid[i][j]);
                
                long tempmin = dp[i - 1][j][0] * grid[i][j];
                tempmin = Math.min(tempmin, dp[i - 1][j][1] * grid[i][j]);
                tempmin = Math.min(tempmin, dp[i][j - 1][0] * grid[i][j]);
                tempmin = Math.min(tempmin, dp[i][j - 1][1] * grid[i][j]);
                
                dp[i][j][0] = tempmax;
                dp[i][j][1] = tempmin;
            }
        }
        
        //System.out.println(dp[row - 1][col - 1][0] + " " + dp[row - 1][col - 1][1]);
        int ans = (int)(dp[row - 1][col - 1][0] % mod);
        if (ans < 0) return -1;
        return ans;
    }
}