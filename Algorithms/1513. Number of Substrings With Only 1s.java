/*
 * @lc app=leetcode id=1513 lang=java
 *
 * [1513] Number of Substrings With Only 1s
 */

// @lc code=start
class Solution {
    public int numSub(String s) {
        /*
            O(n) find length of each substring with all 1s
        */
        int start = 0;
        char[] cs = s.toCharArray();
        int mod = (int)10e8 + 7;
        long ans = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '0') {
                if (start < i) {
                    ans += countOnes(i - start);
                    ans = ans % mod;
                }
                start = i + 1;
            }
        }

        if (start < cs.length) {
            ans += countOnes(cs.length - start);
            ans = ans % mod;
        }

        return (int)ans;
    }

    private long countOnes(int num) {
        long ans = 0;
        while (num >= 1) {
            ans += num;
            num--;
        }

        return ans;
    }
}
// @lc code=end

