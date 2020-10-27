class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        /*
            如果把问题改成只有1,没有0, e.g. strs = ["11", "1", "1111", "111"], m = 6
            就是一个背包问题，每个string中1的个数可以看成是价格， 问m块钱可以最多买多少个物品
            
            Do we add the last string to our answer?
            
            dp[i][j][N] = dp[i][j][N - 1] || dp[i - x][j - y][N - 1]
            i: m
            j: n
            N: number of strings left
        */
        
        int N = strs.length;
        
        int[][][] dp = new int[m + 1][n + 1][N + 1];
        
        for (int k = 1; k <= N; ++k) {
            int x = 0, y = 0;
            char[] cs = strs[k - 1].toCharArray();
            for (char c : cs) {
                if (c == '0') x++;
                else y++;
            }
            
            for (int i = 0; i <= m; ++i) {
                for (int j = 0; j <= n; ++j) {
                    dp[i][j][k] = dp[i][j][k - 1];
                    
                    if (i >= x && j >= y) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - x][j - y][k - 1] + 1);
                    }   
                }
            }
        }
        
        return dp[m][n][N];
    }
}