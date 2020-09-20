class Solution {
    public int numDecodings(String s) {
        /*
            dp
            f[i] = f[i - 1] + f[i - 2]
        */
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        char[] cs = s.toCharArray();
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = 0;
            
            if (cs[i - 1] >= '1' && cs[i - 1] <= '9') dp[i] += dp[i - 1];
            
            if (i > 1) {
                int number = 10 * (cs[i - 2] - '0') + (cs[i - 1] - '0');
                
                if (number >= 10 && number <= 26) 
                {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}