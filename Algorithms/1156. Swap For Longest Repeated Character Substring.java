import java.util.Map;

/*
 * @lc app=leetcode id=1156 lang=java
 *
 * [1156] Swap For Longest Repeated Character Substring
 */

// @lc code=start
class Solution {
    public int maxRepOpt1(String text) {
        /*
            keep counting if 1 different char in between
            reset if 2 continuous chars in between
        */
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = text.toCharArray();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        int start = 0;
        for (char c : map.keySet()) {
            int cur = 0;
            int curmax = 0;
            boolean flag = false;
            start = 0;
            for (int i = 0; i < cs.length; ++i) {
                char c2 = cs[i];
                if (c2 == c) {
                    if (flag) {
                        flag = false;
                        start = i;
                    }
                    cur++;
                } else {
                    curmax = Math.max(curmax, cur);
                    cur = i - start;
                    if (flag) {
                        cur = 0;
                    }
                    flag = true;
                }
            }
            curmax = Math.max(curmax, cur);
            if (map.get(c) > curmax) curmax++;
            ans = Math.max(ans, curmax);
        }

        return ans;
    }
}
// @lc code=end

