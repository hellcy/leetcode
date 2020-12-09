/*
 * @lc app=leetcode id=1006 lang=java
 *
 * [1006] Clumsy Factorial
 */

// @lc code=start
class Solution {
    public int clumsy(int N) {
        if (N == 1) return 1;
        else if (N == 2) return 2;
        else if (N == 3) return 6;
        long n = N;
        long ans = helper(n);
        n -= 3;
        ans += n;
        n--;
        while (n >= 4) {
            ans -= helper(n);
            n -= 3;
            ans += n;
            n--;
        }

        if (n == 1) ans -= n;
        else if (n == 2) ans -= (n * (n - 1));
        else ans -= helper(n);

        return (int)ans;
    }

    private long helper(long x) {
        return x * (x - 1) / (x - 2);
    }
}
// @lc code=end

