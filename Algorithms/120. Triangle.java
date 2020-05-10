class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int row = triangle.size();
        
        int[][] results = new int[row][row];
        for (int[] array : results) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
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
    private int divideConquer(int x, int y, int height, List<List<Integer>> triangle) {
        if (x == height) {
            return 0;
        }
        
        return triangle.get(x).get(y) + Math.min(divideConquer(x + 1, y, height, triangle), divideConquer(x + 1, y + 1, height, triangle));
    }
    
    
    /*
        DFS divide and conquer + memorization
        TLE
        O(n^2) time
    */
    private int divideConquerMemorize(int x, int y, int height, List<List<Integer>> triangle, int[][] results) {
        if (x == height) return 0;
        
        if (results[x][y] != Integer.MAX_VALUE) {
            return results[x][y];
        }
        
        results[x][y] = triangle.get(x).get(y) + Math.min(divideConquer(x + 1, y, height, triangle), divideConquer(x + 1, y + 1, height, triangle));
        
        return results[x][y];
    }
    
    
    /*
        Dynamic programming
        bottom up
        O(n^2)
    */
    private int DPbottomup(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        
        for (int i = 0; i < row; ++i) {
            dp[row - 1][i] = triangle.get(row - 1).get(i);
        }
        
        for (int i = row - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0][0];
    }
    
    /*
        dynamicProgramming
        top down
        O(n^2) time
    */
    private int DPtopdown(List<List<Integer>> triangle) {
        int row = triangle.size();
        
        int[][] dp = new int[row][row];
        
        dp[0][0] = triangle.get(0).get(0);
        
        // triangle left-most column and right-most column
        for (int i = 1; i < row; ++i) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }
        
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
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