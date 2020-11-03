/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String[] array = s.split(" ");

        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i].length() == 0) continue;
            ans += array[i];
            ans += " ";
        }

        return ans.substring(0, ans.length() - 1);
    }
}
// @lc code=end

