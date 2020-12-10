/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();

        int max = 0, min = 20;
        for (String str : words) {
            int length = str.length();
            max = Math.max(max, length);
            min = Math.min(min, length);
            if (!map.containsKey(length)) {
                Set<String> set = new HashSet<>();
                set.add(str);
                map.put(length, set);
            } else {
                map.get(length).add(str);
            }
        }

        int maxans = 1;
        int ans = 1;
        while (min <= max) {
            Set<String> set = map.get(min);
            ans = 1;
            int curlength = min;
            for (int i = min + 1; i <= max; ++i) {
                if (curlength + 1 < i) break;
                for (String str : map.get(i)) {
                    for (int j = 0; j < i; ++j) {
                        String temp = str.substring(0, j) + str.substring(j + 1);
                        if (set.contains(temp)) {
                            //System.out.println(str);
                            set.add(str);
                            if (curlength < i) ans++;
                            curlength = i;
                            break;
                        }
                    }
                }
            }
            maxans = Math.max(maxans, ans);
            min++;
        }

        return maxans;
    }
}
// @lc code=end

