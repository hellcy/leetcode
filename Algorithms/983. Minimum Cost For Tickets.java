class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        /*
            sequence dp
        */
        
        int[] dp = new int[366];
        dp[0] = 0;
        
        Set<Integer> set = new HashSet<>();
        for (int i : days) {
            set.add(i);
        }
        dp[days[0]] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i < days.length; ++i) {
            for (int j = days[i - 1] + 1; j < days[i]; ++j) {
                dp[j] = dp[j - 1];
            }
            dp[days[i]] = Integer.MAX_VALUE;
            if (days[i] >= 1) {
                dp[days[i]] = Math.min(dp[days[i]], dp[days[i] - 1] + costs[0]);
            }
            if (days[i] >= 7) {
                dp[days[i]] = Math.min(dp[days[i]], dp[days[i] - 7] + costs[1]);
            } else dp[days[i]] = Math.min(dp[days[i]], costs[1]);
            if (days[i] >= 30) {
                dp[days[i]] = Math.min(dp[days[i]], dp[days[i] - 30] + costs[2]);
            } else dp[days[i]] = Math.min(dp[days[i]], costs[2]);
        }
        
        // for (int i = 0; i <= days[days.length - 1]; ++i) {
        //     System.out.println(dp[i]);
        // }
        
        return dp[days[days.length - 1]];
    }
}