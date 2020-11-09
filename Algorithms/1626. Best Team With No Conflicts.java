/*
 * @lc app=leetcode id=1626 lang=java
 *
 * [1626] Best Team With No Conflicts
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        /*
            Maximum Incresing Subsequence
            this problem is to find the maximum sum of increasing subsequence.
            Very similiar with 300.Longest Increasing Subsequence

            This problem want both age and score are increasing.
            We can sort by age and do DP for scores.
            Sum up, 3 key points:

            Create another arr by {age[i], socres[i]} and sorted by age.
            For each loop, goes back and find maximum for current DP value to it maintain a increasing subsequence.
            The answer could in any place of the dp array.
            Time complexity: O(n * n), space complexity: O(n)
        */

        int n = scores.length;
        int[][] players = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int[] arr = new int[2];
            arr[0] = scores[i];
            arr[1] = ages[i];
            players[i] = arr;
        }

        Arrays.sort(players, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = players[i][0];
            for (int j = i - 1; j >= 0; --j) {
                if (players[i][0] >= players[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][0]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
// @lc code=end

