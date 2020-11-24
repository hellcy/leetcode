class Solution {
    public int waysToMakeFair(int[] nums) {
        /*
            prefix sum
        */
        int n = nums.length;
        int[] odds = new int[n];
        int[] evens = new int[n];

        int total = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) total += nums[i];
            evens[i] = total;
        }

        total = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 != 0) total += nums[i];
            odds[i] = total;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int odd = odds[i] + (evens[n - 1] - evens[i]);
            int even = evens[i] + (odds[n - 1] - odds[i]);

            if (i % 2 == 0) even -= nums[i];
            else odd -= nums[i];
            if (odd == even) ans++;
        }

        return ans;
    }
}