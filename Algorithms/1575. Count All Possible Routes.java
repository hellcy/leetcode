class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int mod = (int)10e8 + 7;
        
        /*
            Coordinate DP
            dp[i][j]
            i : fuel
            j : city
        */
        
        int cities = locations.length;
        int[][] dp = new int[fuel + 1][cities + 1];
        
        dp[0][start + 1] = 1;

        for (int i = 0; i <= fuel; ++i) {
            for (int j = 1; j <= cities; ++j) {
                int current = 0;
                if (j == start + 1 && i == 0) continue;
                for (int k = 1; k <= cities; ++k) {
                    if (j == k) continue;
                    int distance = Math.abs(locations[j - 1] - locations[k - 1]);
                    if (i - distance >= 0) current = (current + dp[i - distance][k]) % mod;
                }
                
                dp[i][j] = current;
            }
        }
        
        
        // for (int i = 0; i <= fuel; ++i) {
        //     for (int j = 0; j <= cities; ++j) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int ans = 0;
        for (int i = 0; i <= fuel; ++i) {
            ans = (ans + dp[i][finish + 1]) % mod;
        }
        
        return ans;
    }
}