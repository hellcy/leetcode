class Solution {
    public int minCostII(int[][] costs) {
        /*
            Sequence dp
            Similar to paint house I
            time O(N * K * K)
            N: number of houses
            K: number of colors
        */
//         if (costs == null || costs.length == 0) return 0;
//         int houses = costs.length, colors = costs[0].length;
//         int[][] dp = new int[houses + 1][colors];
        
//         for (int i = 0; i <= houses; ++i) {
//             for (int j = 0; j < colors; ++j) {
//                 if (i == 0) {
//                     dp[i][j] = 0;
//                     continue;
//                 }
                
//                 dp[i][j] = Integer.MAX_VALUE;
//                 if (i >= 1) {
//                     for (int k = 0; k < colors; ++k) {
//                         if (k != j || i == 1) dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
//                     }
//                 }
//             }
//         }
        
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < colors; ++i) {
//             min = Math.min(min, dp[houses][i]);
//         }
//         return min;
        
        /*
            Optimization: 
            pick the smallest and the second smallest cost of all colors
            reduce the min calculation to O(1) and totoal time complexity from O(N * K * K) to O(N * K * 2)
            Note: Pay attention to the first house as it doesn't have small1 and small2 ready
        */
        
        if (costs == null || costs.length == 0) return 0;
        int houses = costs.length, colors = costs[0].length;
        int[][] dp = new int[houses + 1][colors];
        for (int i = 0; i < colors; ++i) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i <= houses; ++i) {
            // get the smallest and the second smallest cost of house i
            int first = -1, second = -1, small1 = Integer.MAX_VALUE, small2 = Integer.MAX_VALUE;
            for (int j = 0; j < colors; ++j) {
                if (small1 > dp[i - 1][j]) {
                    small2 = small1;
                    second = first;
                    small1 = dp[i - 1][j];
                    first = j;
                } else if (small2 > dp[i - 1][j]) {
                    small2 = dp[i - 1][j];
                    second = j;
                }
            }
            
            
            for (int j = 0; j < colors; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                if (j != first || i == 1) dp[i][j] = small1 + costs[i - 1][j];
                else dp[i][j] = small2 + costs[i - 1][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < colors; ++i) {
            min = Math.min(min, dp[houses][i]);
        }
        return min;
    }
}