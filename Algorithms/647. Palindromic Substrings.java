class Solution {
    public int countSubstrings(String s) {
        /*
            expand from the center point dp
        */
        
        int count = 0;
        
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            count++;
        }
        
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (i - 1 <= j + 1 && cs[i] == cs[j] && dp[i - 1][j + 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}