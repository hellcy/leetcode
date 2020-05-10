class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
            Coordinates dynamic programming
            注意初始化第0行和第0列如果遇到障碍，
            那么之后的所有grid都要变成0
        */
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length, column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        
        for (int i = 0; i < row; ++i) {
            if (obstacleGrid[i][0] == 1) {
                while (i < row) {
                    dp[i][0] = 0;
                    i++;
                }
                break;
            }
            else dp[i][0] = 1;
        }
        
        for (int i = 0; i < column; ++i) {
            if (obstacleGrid[0][i] == 1) {
                while (i < column) {
                    dp[0][i] = 0;
                    i++;
                }
                break;
            }
            else dp[0][i] = 1;
        }
        
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < column; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[row - 1][column - 1];
    }
}