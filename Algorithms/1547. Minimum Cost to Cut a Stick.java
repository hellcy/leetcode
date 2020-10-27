class Solution {
    public int minCost(int n, int[] cuts) {
        /*
            range dp
            dp[i][j] = Math.min(i < cuts[k] < j) (dp[i][k] + dp[k][j] + (j - i))
            i: start index
            j: end index
            
            similar to burst balloons
            add two sentinel values 0 and n at the begining and end of cuts
            starts at len = 1, we cannot cut so dp[i - 1][i] = 0
            for 2 <= len <= n, find all possible cuts between i and j, save the minimum answer
            if there is no cuts between i and j, dp[i][j] should be 0
        */
        int m = cuts.length;
        int[][] dp = new int[m + 2][m + 2];
        for (int[] array : dp) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        m += 2;
        for (int i = 1; i < m; ++i) {
            dp[i - 1][i] = 0;
        }
        
        int[] array = new int[m];
        array[0] = 0;
        array[m - 1] = n;
        Arrays.sort(cuts);
        for (int i = 1; i < m - 1; ++i) {
            array[i] = cuts[i - 1];
        }
        
        for (int len = 2; len < m; ++len) {
            for (int i = 0; i < m - len; ++i) {
                int j = i + len;
                int left = array[i];
                int right = array[j];
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (right - left));
                }
            }
        }
        
        return dp[0][m - 1];
    }
}