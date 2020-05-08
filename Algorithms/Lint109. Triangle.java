public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int row = triangle.length;
        
        int[][] results = new int[row][row];
        for (int[] array : results) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }


        /*
            4 methods are provided, the first two will TLE
            last two are DP solutions, the third solution is the best for this problem
        */
        //return divideConquer(0, 0, row, triangle);
        //return divideConquerMemorize(0, 0, row, triangle, results);
        //return DPbottomup(triangle);
        return DPtopdown(triangle);
    }
    
    /*
        DFS divide and conquer
        TLE
        O(2^n) time
    */
    private int divideConquer(int x, int y, int height, int[][] triangle) {
        if (x == height) {
            return 0;
        }
        
        return triangle[x][y] + Math.min(divideConquer(x + 1, y, height, triangle), divideConquer(x + 1, y + 1, height, triangle));
    }
    
    
    /*
        DFS divide and conquer + memorization
        TLE
        O(n^2) time
    */
    private int divideConquerMemorize(int x, int y, int height, int[][] triangle, int[][] results) {
        if (x == height) return 0;
        
        if (results[x][y] != Integer.MAX_VALUE) {
            return results[x][y];
        }
        
        results[x][y] = triangle[x][y] + Math.min(divideConquer(x + 1, y, height, triangle), divideConquer(x + 1, y + 1, height, triangle));
        
        return results[x][y];
    }
    
    
    /*
        Dynamic programming
        bottom up
        O(n^2)
    */
    private int DPbottomup(int[][] triangle) {
        int row = triangle.length;
        int[][] dp = new int[row][row];
        
        for (int i = 0; i < row; ++i) {
            dp[row - 1][i] = triangle[row - 1][i];
        }
        
        for (int i = row - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        
        return dp[0][0];
    }
    
    /*
        dynamicProgramming
        top down
        O(n^2) time
    */
    private int DPtopdown(int[][] triangle) {
        int row = triangle.length;
        
        int[][] dp = new int[row][row];
        
        dp[0][0] = triangle[0][0];
        
        // triangle left-most column and right-most column
        for (int i = 1; i < row; ++i) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
        }
        
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < row; ++i) {
            if (dp[row - 1][i] < min) {
                min = dp[row - 1][i];
            }
        }
        
        return min;
    }
}