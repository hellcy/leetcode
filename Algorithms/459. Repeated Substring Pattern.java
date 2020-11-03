/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] cs = s.toCharArray();

        int n = cs.length;
        if (n == 0) return false;
        
        for (int len = 1; len <= n / 2; ++len) {
            boolean flag = false;
            for (int i = 0; i <= n - len - len; i += len) {
                if (!s.substring(i, i + len).equals(s.substring(i + len, i + len + len))) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                if (n % len == 0) return true;
                else return false;
            }
        }

        return false;
    }
}
// @lc code=end

