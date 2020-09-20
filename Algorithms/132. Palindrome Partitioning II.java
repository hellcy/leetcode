class Solution {
    public int minCut(String s) {
        /*
            1. find all possible palindrome from the string s ans store them in a 2d array
                expand palindrome start and end index to both sides
            2. partition dp
            dp[i] = min(dp[i], dp[j] && isPalin(s[j][i - 1]))
        */
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        char[] cs = s.toCharArray();
        boolean[][] isPalin = getPalin(cs);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; ++j) {
                if (isPalin[j][i - 1]) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
            
        }
        
        return dp[n] - 1;
    }
    
    private boolean[][] getPalin(char[] cs) {
        int n = cs.length;
        boolean[][] isPalin = new boolean[n][n];
        
        // i is at char position
        for (int i = 0; i < n; ++i) {
            int left = i, right = i;
            while (left >= 0 && right < n && cs[left] == cs[right]) {
                isPalin[left][right] = true;
                left--;
                right++;
            }
        }
        
        // i is at between two chars
        for (int i = 0; i < n - 1; ++i) {
            int left = i, right = i + 1;
            while (left >= 0 && right < n && cs[left] == cs[right]) {
                isPalin[left][right] = true;
                left--;
                right++;
            }
        }
        
        return isPalin;
    }
}